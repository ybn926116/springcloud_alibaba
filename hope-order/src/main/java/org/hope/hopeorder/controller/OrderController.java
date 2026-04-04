package org.hope.hopeorder.controller;

import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;
import org.hope.hopeorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public Result<?> createOrder(@RequestParam("userId") String userId,
                                 @RequestParam("commodityCode") String commodityCode,
                                 @RequestParam("count") Integer count) {
        Result<?> result = null;
        try {
            result = orderService.createOrder(userId, commodityCode, count);
        } catch (BusinessException e) {
            return Result.failed(e.getMessage());
        }

        return result;
    }

    @GetMapping("/getOrder")
    public Result<?> getOrder(@RequestParam("userId") String userId) {
        Result<?> result = null;
        try {
            result = orderService.getOrderByUserId(userId);
        } catch (BusinessException e) {
            return Result.failed(e.getMessage());
        }
        return result;
    }

}
