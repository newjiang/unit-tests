package org.jiang.unit.serivce;

import org.jiang.unit.code.Result;
import org.jiang.unit.mapper.AccountMapper;
import org.jiang.unit.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @MockBean(name = "accountMapper")
    private AccountMapper accountMapper;

    @Test
    void create() {
        Account account = new Account();
        Assertions.assertEquals(accountService.create(account), Result.failure("id不合法"));

        account.setId(1001L);
        Assertions.assertEquals(accountService.create(account), Result.failure("年龄不合法"));

        account.setAge(99);
        Assertions.assertEquals(accountService.create(account), Result.failure("姓名不合法"));

        account.setName("单元");
        Assertions.assertEquals(accountService.create(account), Result.failure("手机不合法"));

        account.setPhone("13579000111");
        Assertions.assertEquals(accountService.create(account), Result.failure("邮箱不合法"));

        account.setEmail("123456789@666.org");

        Mockito.when(accountMapper.insert(Mockito.any())).thenReturn(0);
        Assertions.assertEquals(Result.failure("新增失败"), accountService.create(account));

        Mockito.when(accountMapper.insert(Mockito.any())).thenReturn(1);
        Assertions.assertEquals(Result.success("新增成功"), accountService.create(account));
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(accountService.deleteById(-3003L), Result.failure("id不合法"));
        Assertions.assertEquals(accountService.deleteById(3003L), Result.failure("删除失败"));
    }

    @Test
    void update() {
        Account account = new Account();
        Assertions.assertEquals(accountService.update(account), Result.failure("id不合法"));

        account.setId(2002L);
        Assertions.assertEquals(accountService.update(account), Result.failure("年龄不合法"));

        account.setAge(99);
        Assertions.assertEquals(accountService.update(account), Result.failure("姓名不合法"));

        account.setName("单元");
        Assertions.assertEquals(accountService.update(account), Result.failure("手机不合法"));

        account.setPhone("13579000111");
        Assertions.assertEquals(accountService.update(account), Result.failure("邮箱不合法"));

        account.setEmail("123456789@666.org");
        Assertions.assertEquals(accountService.update(account), Result.failure("修改失败"));

        Mockito.when(accountMapper.update(Mockito.eq(account))).thenReturn(0);
        Assertions.assertEquals(Result.failure("修改失败"), accountService.update(account));

        Mockito.when(accountMapper.update(Mockito.eq(account))).thenReturn(1);
        Assertions.assertEquals(Result.success("修改成功"), accountService.update(account));
    }

    @Test
    void queryById() {
        Account account = new Account();
        account.setId(1L);
        account.setName("刘一");
        account.setAge(11);
        account.setPhone("13579000111");
        account.setEmail("liuyi@unit.test.org");
        Assertions.assertEquals(accountService.queryById(-1L), Result.failure("id不合法"));

        Mockito.when(accountMapper.queryById(Mockito.eq(1L))).thenReturn(account);
        Assertions.assertEquals(Result.success(account), accountService.queryById(1L));
    }

    @Test
    void queryAll() {
        List<Account> accounts = Collections.singletonList(new Account());
        Mockito.when(accountMapper.queryAll()).thenReturn(accounts);

        Result<List<Account>> result = accountService.queryAll();
        Assertions.assertEquals(result.getCode(), 200);
        Assertions.assertEquals(result.getMessage(), "success");
        Assertions.assertTrue(result.getData().size() > 0);
    }
}