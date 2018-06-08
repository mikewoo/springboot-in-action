package com.mikewoo.study.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserController单元测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/8 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    private static final String REQUEST_PREFIX = "/user";

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getUsers() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_PREFIX)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        logger.info("response: {}", response);
        // 返回结果 response: [{"id":"191234","name":"Phantom","age":28,"email":"phantom@test.com"},{"id":"191235","name":"Eric","age":29,"email":"eric@test.com"},{"id":"191236","name":"Justin","age":31,"email":"justin@test.com"}]

    }

    @Test
    public void getUserById() throws Exception {
        String userId = "191235";
        String response = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_PREFIX + "/" + userId).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        logger.info("response: {}", response);
        // 返回结果 response: {"id":"191235","name":"Phantom","age":28,"email":"phantom@test.com"}
    }

    @Test
    public void addUser() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_PREFIX)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("id", "198123")
                .param("name", "Skye")
                .param("age", "28")
                .param("email", "skye@test.com"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        logger.info("response: {}", response);
        // 返回结果： response: {"id":"198123","name":"Skye","age":28,"email":"skye@test.com"}
    }

    // 测试使用hibernate-validator进行参数校验
    @Test
    public void addUserValid() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_PREFIX)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                //.param("id", "198123")  // error: valid error, code: NotEmpty, message: id不能为空
                .param("name", "Skye")
                .param("age", "12") // error: valid error, code: Min, message: 年龄不能小于18岁
                .param("email", "skye.com")) // error: valid error, code: Email, message: 邮箱格式不合法
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        logger.info("response: {}", response);
        // 返回结果： response:
    }
}