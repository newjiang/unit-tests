package org.jiang.unit.serivce;

import lombok.extern.slf4j.Slf4j;
import org.jiang.unit.code.Result;
import org.jiang.unit.mapper.AccountMapper;
import org.jiang.unit.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private VerifyService verifyService;

    /**
     * 新增
     *
     * @param account 实体
     * @return 结果
     */
    public Result<String> create(Account account) {
        if (!verifyService.isId(account.getId())) {
            return Result.failure("id不合法");
        }
        if (!verifyService.isAge(account.getAge())) {
            return Result.failure("年龄不合法");
        }
        if (!verifyService.isName(account.getName())) {
            return Result.failure("姓名不合法");
        }
        if (!verifyService.isPhone(account.getPhone())) {
            return Result.failure("手机不合法");
        }
        if (!verifyService.isEmail(account.getEmail())) {
            return Result.failure("邮箱不合法");
        }
        int insert = accountMapper.insert(account);
        return insert > 0 ? Result.success("新增成功") : Result.failure("新增失败");
    }

    /**
     * 根据ID删除
     *
     * @param id id
     * @return 结果
     */
    public Result<String> deleteById(Long id) {
        if (!verifyService.isId(id)) {
            return Result.failure("id不合法");
        }
        int delete = accountMapper.deleteById(id);
        return delete > 0 ? Result.success("删除成功") : Result.failure("删除失败");
    }

    /**
     * 更新
     *
     * @param account 实体
     * @return 结果
     */
    public Result<String> update(Account account) {
        if (!verifyService.isId(account.getId())) {
            return Result.failure("id不合法");
        }
        if (!verifyService.isAge(account.getAge())) {
            return Result.failure("年龄不合法");
        }
        if (!verifyService.isName(account.getName())) {
            return Result.failure("姓名不合法");
        }
        if (!verifyService.isPhone(account.getPhone())) {
            return Result.failure("手机不合法");
        }
        if (!verifyService.isEmail(account.getEmail())) {
            return Result.failure("邮箱不合法");
        }
        int update = accountMapper.update(account);
        return update > 0 ? Result.success("修改成功") : Result.failure("修改失败");
    }

    /**
     * 根据ID查询
     *
     * @param id id
     * @return 实体
     */
    public Result<Account> queryById(Long id) {
        if (!verifyService.isId(id)) {
            return Result.failure("id不合法");
        }
        return Result.success(accountMapper.queryById(id));
    }

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    public Result<List<Account>> queryAll() {
        return Result.success(accountMapper.queryAll());
    }
}
