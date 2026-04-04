package org.hope.hopeorder.feign;

import org.hope.hopecommon.Result;
import org.hope.hopeorder.feign.dto.StorageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hope-storage")
public interface StorageServiceFeignClient {

    @PostMapping("/storage/reduce-stock")
    Result<?> reduceStock(@RequestBody StorageDTO storageDTO);
}
