package org.jiang.unit.serivce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VerifyServiceTest {
    @Autowired
    private VerifyService verifyService;

    @Test
    void isId() {
        Assertions.assertTrue(verifyService.isId(1L), "合法id");
        Assertions.assertFalse(verifyService.isId(-1L), "非法id");
    }

    @Test
    void isAge() {
        Assertions.assertFalse(verifyService.isAge(-1), "非法年龄");
        Assertions.assertTrue(verifyService.isAge(0), "合法年龄");
        Assertions.assertTrue(verifyService.isAge(100), "合法年龄");
        Assertions.assertFalse(verifyService.isAge(101), "非法年龄");
    }

    @Test
    void isName() {
        Assertions.assertTrue(verifyService.isName("张三"), "合法名称");
        Assertions.assertFalse(verifyService.isName("张3"), "非法名称");
        Assertions.assertFalse(verifyService.isName("张san"), "非法名称");
        Assertions.assertFalse(verifyService.isName("张三!!!"), "非法名称");
    }

    @Test
    void isEmail() {
        Assertions.assertTrue(verifyService.isEmail("123456789@666.com"), "合法邮箱");
        Assertions.assertFalse(verifyService.isEmail("123456789@666.com."), "非法邮箱");
        Assertions.assertFalse(verifyService.isEmail(".123456789@666.com"), "非法邮箱");
        Assertions.assertFalse(verifyService.isEmail(".123456789666.com"), "非法邮箱");
        Assertions.assertFalse(verifyService.isEmail(".123456789@666"), "非法邮箱");
        Assertions.assertFalse(verifyService.isEmail("123456789@666.com.啥"), "非法邮箱");
        Assertions.assertFalse(verifyService.isEmail("123456789@666.com.?"), "非法邮箱");
    }

    @Test
    void isPhone() {
        Assertions.assertTrue(verifyService.isPhone("13579000111"), "合法手机");
        Assertions.assertFalse(verifyService.isPhone("110"), "非法手机");
        Assertions.assertFalse(verifyService.isPhone("11111111111"), "非法手机");
        Assertions.assertFalse(verifyService.isPhone("13579000111000"), "非法手机");
        Assertions.assertFalse(verifyService.isPhone("1357900011A"), "非法手机");
        Assertions.assertFalse(verifyService.isPhone("1357900011?"), "非法手机");
    }
}