package org.hope.hopestorage.controller;

import org.hope.hopecommon.Result;
import org.hope.hopestorage.dto.StorageDTO;
import org.hope.hopestorage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@CrossOrigin
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/reduce-stock")
    public Result<?> reduceStock(@RequestBody StorageDTO storageDTO){
        try {
            storageService.reduceStock(storageDTO.getCommodityCode(),storageDTO.getCount());
        }catch (Exception e){
            return Result.failed(e.getMessage());
        }
        return Result.success("成功");
    }

    @GetMapping("/")
    public Result<?> getRemainStock(@RequestParam("commodityCode") String commodityCode){
        return storageService.getRemainCount(commodityCode);
    }
}
