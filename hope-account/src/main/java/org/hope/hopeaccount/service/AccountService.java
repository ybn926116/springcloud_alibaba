package org.hope.hopeaccount.service;

import org.hope.hopecommon.Result;

public interface AccountService {
    void reduceBalance(String userId, Integer price);

    Result<?> getRemainAccount(String userId);
}
