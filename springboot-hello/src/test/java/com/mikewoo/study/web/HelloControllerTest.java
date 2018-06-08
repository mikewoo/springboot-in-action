package com.mikewoo.study.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * HelloController测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void sayHelloTest() throws Exception {
        String content = mockMvc.perform(MockMvcRequestBuilders.get("/sayHello")
                .param("name", "Phantom")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("response content: " + content);
        /**
         * 输出结果
         MockHttpServletRequest:
         HTTP Method = GET
         Request URI = /sayHello
         Parameters = {name=[Phantom]}
         Headers = {Accept=[application/json;charset=UTF-8]}
         Body = <no character encoding set>
         Session Attrs = {}

         Handler:
         Type = com.mikewoo.study.web.HelloController
         Method = public java.lang.String com.mikewoo.study.web.HelloController.sayHello(java.lang.String)

         Async:
         Async started = false
         Async result = null

         Resolved Exception:
         Type = null

         ModelAndView:
         View name = null
         View = null
         Model = null

         FlashMap:
         Attributes = null

         MockHttpServletResponse:
         Status = 200
         Error message = null
         Headers = {Content-Type=[application/json;charset=UTF-8], Content-Length=[14]}
         Content type = application/json;charset=UTF-8
         Body = hello, Phantom
         Forwarded URL = null
         Redirected URL = null
         Cookies = []

         response content: hello, Phantom

         */
    }

}
