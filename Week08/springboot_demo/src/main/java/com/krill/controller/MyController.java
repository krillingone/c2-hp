package com.krill.controller;

import com.krill.entity.Account;
import com.krill.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/account")
public class MyController {

    @Autowired
    private AccountService service;

    //查询所有
    @RequestMapping("/all")
    @ResponseBody
    public List<Account> findAll() {
        return service.findAll();
    }
    //保存account对象
    @RequestMapping("/save")
    public void saveAccount(@RequestBody Account account) {
        service.insert(account);
    }

    @RequestMapping("/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {
        service.transfer(remitterId, remitteeId, money);
    }
}
