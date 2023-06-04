package org.jiang.unit.mapper;

import org.jiang.unit.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@SpringBootTest
class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    void insert() {
        Account account = new Account();
        account.setId(50001L).setName("新增").setAge(20).setPhone("110").setEmail("666");
        Assertions.assertEquals(1, accountMapper.insert(account));

        // 主键冲突测试
        Assertions.assertThrows(DuplicateKeyException.class, () -> accountMapper.insert(account));
    }

    @Test
    void deleteById() {
        long id = 30001L;
        accountMapper.deleteById(id);
        Account account = new Account();
        account.setId(id).setName("新增").setAge(20).setPhone("110").setEmail("666");
        Assertions.assertEquals(1, accountMapper.insert(account));
        Assertions.assertEquals(1, accountMapper.deleteById(id));
        Assertions.assertEquals(0, accountMapper.deleteById(id));
    }

    @Test
    void update() {
        Account account = new Account();
        account.setId(30001L).setName("新增").setAge(20).setPhone("110").setEmail("666");
        Assertions.assertEquals(1, accountMapper.insert(account));
    }

    @Test
    void queryById() {
        Account account = accountMapper.queryById(1L);
        Account expected = new Account();
        expected.setId(1L);
        expected.setName("刘一");
        expected.setAge(11);
        expected.setEmail("liuyi@unit.test.org");
        expected.setPhone("13579000111");
        Assertions.assertEquals(expected, account);
    }

    @Test
    void queryAll() {
        List<Account> accounts = accountMapper.queryAll();
        Assertions.assertTrue(accounts.size() > 0);
    }
}