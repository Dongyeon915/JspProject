package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// controller test
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class BoardControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    // MockMvc는 웹 어플리케이션을 애플리케이션 서버에 배포하지 않고 테스트용 MVC환경을 만들어 요청 및 전송, 응답기능을 제공해주는
    // 유틸리티 클래스다
    private MockMvc mockMvc;

    @Before
    public void setup() {
	this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
	log.info(
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
    }
    
    // 서버 실행없이도 테이터 수정가능
    @Test
    public void testRegister() throws Exception {
	log.info(
		mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "Test 테스트").param("content", "Content")
			.param("writer", "ehddus")
			).andReturn());
    }
}
