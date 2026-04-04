package org.hope.hopestorage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;
import org.hope.hopestorage.mapper.StorageMapper;
import org.hope.hopestorage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    @Transactional
    public void reduceStock(String commodityCode, Integer orderCount) throws BusinessException {
        checkStock(commodityCode, orderCount);
        log.info("reduceStock commodityCode:{} orderCount:{}", commodityCode, orderCount);
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        int update = storageMapper.reduceStock(commodityCode, orderCount,updateTime);
        if (update == 0) {
            throw new BusinessException("减库存失败");
        }

    }

    /**
     * 剩余库存
     * @param commodityCode
     * @return
     */
    @Override
    public Result<?> getRemainCount(String commodityCode) {
        Integer stock = storageMapper.getStock(commodityCode);
        if (stock == null) {
            throw new BusinessException("商品不存在");
        }
        return Result.success(stock);
    }

    private void checkStock(String commodityCode, Integer count){
        Integer stock = storageMapper.getStock(commodityCode);
        if (stock < count) {
            throw new BusinessException("库存不足");
        }
    }
}
