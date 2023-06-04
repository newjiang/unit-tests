package org.jiang.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jiang.unit.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {
        // 创建新增对象
        Account account = new Account();
        account.setId(1001L).setName("新增").setAge(11).setPhone("13579000111").setEmail("13579000111@666.com");

        // 构造请求
        MockHttpServletRequestBuilder post
                = MockMvcRequestBuilders
                .post("/account") // 请求方式
                .contentType(MediaType.APPLICATION_JSON_UTF8) // 请求格式类型
                .accept(MediaType.APPLICATION_JSON_UTF8) // 响应格式类型
                .content(objectMapper.writeValueAsString(account)); // 请求内容json

        // 发送请求并验证结果
        mockMvc.perform(post)
                .andDo(print()) // 打印请求和响应报文
                .andExpect(status().isOk()) // 响应码 200
                .andExpect(jsonPath("$.code").value(200)) // 期待的返回码
                .andExpect(jsonPath("$.message").value("success")) // 期待的信息
                .andExpect(jsonPath("$.data").value("新增成功")); // 响应的数据

    }

    @Test
    void deleteById() throws Exception {
        long id = 1L;

        // 构造请求
        MockHttpServletRequestBuilder post
                = MockMvcRequestBuilders
                .delete("/account/" + id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8);

        // 发送请求并验证结果
        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("删除成功"));
    }

    @Test
    void update() throws Exception {
        // 创建新增对象
        Account account = new Account();
        account.setId(1L).setName("更新").setAge(11).setPhone("13579000111").setEmail("13579000111@666.com");

        // 构造请求
        MockHttpServletRequestBuilder post
                = MockMvcRequestBuilders
                .put("/account")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(account));

        // 发送请求并验证结果
        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("修改成功"));
    }

    @Test
    void queryById() throws Exception {
        long id = 1L;

        // 构造请求
        MockHttpServletRequestBuilder post
                = MockMvcRequestBuilders
                .get("/account/" + id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8);

        // 发送请求并验证结果
        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.name").value("刘一"))
                .andExpect(jsonPath("$.data.age").value(11))
                .andExpect(jsonPath("$.data.phone").value("13579000111"))
                .andExpect(jsonPath("$.data.email").value("liuyi@unit.test.org"));
    }

    @Test
    void queryAll() throws Exception {
        // 构造请求
        MockHttpServletRequestBuilder post
                = MockMvcRequestBuilders
                .get("/account/queryAll")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8);

        // 发送请求并验证结果
        mockMvc.perform(post)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"));
    }
}