package org.jiang.unit.controller;

import org.jiang.unit.code.Result;
import org.jiang.unit.model.Account;
import org.jiang.unit.serivce.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 新增
     *
     * @param account 实体
     * @return 结果
     */
    @PostMapping("/account")
    public Result<String> create(@RequestBody Account account) {
        return accountService.create(account);
    }

    /**
     * 根据ID删除
     *
     * @param id id
     * @return 结果
     */
    @DeleteMapping("/account/{id}")
    public Result<String> deleteById(@PathVariable("id") Long id) {
        return accountService.deleteById(id);
    }

    /**
     * 更新
     *
     * @param account 实体
     * @return 结果
     */
    @PutMapping("/account")
    public Result<String> update(@RequestBody Account account) {
        return accountService.update(account);
    }

    /**
     * 根据ID查询
     *
     * @param id id
     * @return 实体
     */
    @GetMapping("/account/{id}")
    public Result<Account> queryById(@PathVariable("id") Long id) {
        return accountService.queryById(id);
    }

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    @GetMapping("/account/queryAll")
    public Result<List<Account>> queryAll() {
        return accountService.queryAll();
    }
}
