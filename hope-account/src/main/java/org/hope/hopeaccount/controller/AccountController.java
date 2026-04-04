package org.hope.hopeaccount.controller;

import org.hope.hopeaccount.dto.AccountDTO;
import org.hope.hopeaccount.service.AccountService;
import org.hope.hopecommon.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/reduce-balance")
    public Result<?> reduceBalance(@RequestBody AccountDTO accountDTO) {
        accountService.reduceBalance(accountDTO.getUserId(),accountDTO.getPrice());
        return Result.success("");
    }


    @GetMapping("/")
    public Result<?> getRemainAccunt(@RequestParam("userId") String userId){
        return accountService.getRemainAccount(userId);
    }
}
