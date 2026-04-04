package org.hope.hopeaccount.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hope.hopeaccount.mapper.AccountMapper;
import org.hope.hopeaccount.service.AccountService;
import org.hope.hopecommon.BusinessException;
import org.hope.hopecommon.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void reduceBalance(String userId, Integer price) throws BusinessException {
        checkBalance(userId, price);

        Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
        int i = accountMapper.reduceBalance(userId, price, updatedTime);
        if (i == 0) {
            throw new BusinessException("余额不足");
        }
    }

    /**
     * 获取账户余额
     * @param userId
     * @return
     */
    @Override
    public Result<?> getRemainAccount(String userId) {
        Integer balance = accountMapper.getBalance(userId);
        if (balance == null) {
            throw new BusinessException("用户不存在");
        }
        return Result.success(balance);
    }

    private void checkBalance(String userId, Integer price) throws BusinessException {
        Integer balance = accountMapper.getBalance(userId);
        if (balance < price) {
            throw new BusinessException("余额不足");
        }
    }
}
