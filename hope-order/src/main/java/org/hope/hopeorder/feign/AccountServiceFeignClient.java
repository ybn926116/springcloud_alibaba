package org.hope.hopeorder.feign;

import org.hope.hopecommon.Result;
import org.hope.hopeorder.feign.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hope-account")
public interface AccountServiceFeignClient {

    @PostMapping("/account/reduce-balance")
    Result<?> reduceBalance(@RequestBody AccountDTO accountDTO);
}
