package org.hope.hopeorder.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;
import org.hope.hopecommon.ResultEnum;
import org.hope.hopeorder.entity.Order;
import org.hope.hopeorder.feign.AccountServiceFeignClient;
import org.hope.hopeorder.feign.StorageServiceFeignClient;
import org.hope.hopeorder.feign.dto.AccountDTO;
import org.hope.hopeorder.feign.dto.StorageDTO;
import org.hope.hopeorder.mapper.OrderMapper;
import org.hope.hopeorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountServiceFeignClient accountService;

    @Autowired
    private StorageServiceFeignClient storageService;

    @Override
    public Result<?> createOrder(String userId, String commodityCode, Integer count) throws BusinessException {

        StorageDTO storageDTO = new StorageDTO();
        storageDTO.setCommodityCode(commodityCode);
        storageDTO.setCount(count);
        String url = "http://hope-storage/storage/reduce-stock";
        Result result = storageService.reduceStock(storageDTO);
        if (result.getCode() == ResultEnum.COMMON_FAILED.getCode()) {
            throw new BusinessException("库存不足");
        }

        int price = count * 2;
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(userId);
        accountDTO.setPrice(price);
//        url = "http://hope-account/account/reduce-balance";
//        Result resultAccount = restTemplate.postForObject(url, accountDTO, Result.class);
        Result resultAccount = accountService.reduceBalance(accountDTO);
        if (resultAccount.getCode() == ResultEnum.COMMON_FAILED.getCode()) {
            throw new BusinessException("余额不足");
        }
        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        order.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        order.setMoney(price);
        order.setUserId(userId);


        int i = orderMapper.saveOrder(order);
        log.info("插入订单数据:{}",order.getId());
        if (i == 0) {
            throw new BusinessException("下单失败");
        }
        return Result.success("下单成功");
    }

    @Override
    public Result<?> getOrderByUserId(String userId) {
        List<Order> list = orderMapper.getOrderByUserId(userId);
        return Result.success(list);
    }
}
