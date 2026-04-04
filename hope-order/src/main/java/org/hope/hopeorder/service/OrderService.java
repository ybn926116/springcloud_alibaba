package org.hope.hopeorder.service;

import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;

public interface OrderService {

    Result<?> createOrder(String userId, String commodityCode, Integer count) throws BusinessException;

    Result<?> getOrderByUserId(String userId);
}
