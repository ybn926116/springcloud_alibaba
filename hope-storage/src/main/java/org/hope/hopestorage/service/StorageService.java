package org.hope.hopestorage.service;

import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;

public interface StorageService {

    void reduceStock(String commodityCode, Integer orderCount) throws BusinessException;

	Result<?> getRemainCount(String commodityCode) throws BusinessException;
}
