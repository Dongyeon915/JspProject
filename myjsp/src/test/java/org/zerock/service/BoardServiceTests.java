package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
    
    @Autowired
    private BoardService service;
    
    @Test
    public void testPrint() {
	log.info(service);
    }
    
    @Test
    public void testGetList() {
	log.info(service.getList());
    }
    
    @Test
    public void modityVO() {
	BoardVO boardVO = new BoardVO();
	boardVO.setTitle("업데이트 테스트");
	boardVO.setBno(3);
	log.info("수정테스트" + service.modify(boardVO));
    }
}
