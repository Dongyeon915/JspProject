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
// 서블릿의 서블릿콘텍스트를 이용하기 위함
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardControllerTests {
    
    @Autowired
    private WebApplicationContext ctx;
    // 가짜 mvc 가짜로 파라미터와  url들을 브라우저에서 사용하는것처럼 만들어서 controller test를 가능하게한다.
    private MockMvc moMvc;
    // 모든 메서드가 실행되기 전 실행되는 before
    @Before
    public void setup() {
	this.moMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    
//   @Test
//    public void testList() throws Exception {
//	// get요청을 진행
//	log.info(moMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//		.andReturn().getModelAndView().getModelMap());
//    }
//    
//    @Test
//    public void testRegister() throws Exception {
//	String resultPage = moMvc.perform(MockMvcRequestBuilders.post("/board/register")
//		.param("title", "테스트 새글 제목")
//		.param("content", "테스트 새글 내용")
//		.param("writer", "동연 테스트")).andReturn().getModelAndView().getViewName();
//	log.info(resultPage);
//    }
    
//    @Test
//    public void testGet() throws Exception {
//	log.info(moMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "10"))
//		.andReturn().getModelAndView().getModelMap());
//    }
    
    
//  @Test
//  public void testModify() throws Exception {
//	String resultPage = moMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//		.param("bno", "10")
//		.param("title", "수정된 테스트 새글 제목")
//		.param("content", "수정된 테스트 새글 내용")
//		.param("writer", "동연 테스트")).andReturn().getModelAndView().getViewName();
//	log.info(resultPage);
//  }
    
//    @Test
//    public void testRemove() throws Exception {
//	// 삭제전 데이터 베이스에 게시물 번호 확인할 것
//	String resultPage = moMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//		.param("bno", "25")).andReturn().getModelAndView().getViewName();
//	log.info(resultPage);
//    }
    
    @Test
    public void testListPaging() throws Exception {
	log.info(moMvc.perform(
		MockMvcRequestBuilders.get("/board/list")
		.param("pageNum", "2")
		.param("amount", "10"))
		.andReturn().getModelAndView().getModelMap()
		);
    }
}
