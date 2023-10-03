package org.zerock.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
    
  @Autowired
  private BoardMapper mapper;
  
//  @Test
//  public void testGetList() {
//      mapper.getList().forEach(board -> log.info(board));
//  }
//  
//  @Test
//  public void testInsert() {
//      BoardVO board = new BoardVO();
//      board.setTitle("새로 작성하는 글");
//      board.setContent("새로 작성하는 내용");
//      board.setWriter("newbie");
//      
//      mapper.insert(board);
//      // lombok이 만들어주는 toString을 확인
//      log.info(board);
//  }
//  
//  @Test
//  public void testInsertSelectKey() {
//      BoardVO board = new BoardVO();
//      board.setTitle("새로 작성하는 글 select Key");
//      board.setContent("새로작성하는 내용 select Key");
//      board.setWriter("동연");
//      
//      mapper.insertSelectKey(board);
//      
//      log.info(board);
//  }
  
//  @Test
//  public void testRead() {
//      BoardVO board = mapper.read(5L);
//      System.out.println("---------------------------------------------------------");
//      log.info(board);
//  }
  
//  @Test
//  public void testDelete() {
//      log.warn("삭제된 갯수는 : " + mapper.delete(3L));
//  }
  
//  @Test
//  public void testUpdate() {
//      BoardVO board = new BoardVO();
//      // 실행전 존재하는 번호인지 확인 할것
//      board.setBno(5L);
//      board.setTitle("수정된 제목");
//      board.setContent("수정된 내용");
//      board.setWriter("동연");
//      
//      int count = mapper.update(board);
//      log.info("업데이트 된 갯수는 : " + count);
//  }
  
//  @Test
//  public void testPaging() {
//      Criteria cri = new Criteria();
//      //10개씩 3페이지
//      cri.setPageNum(3);
//      cri.setAmount(10);
//      
//      List<BoardVO> list = mapper.getListWithPaging(cri);
//      list.forEach(board -> log.info(board));
//  
//  }
  
  @Test
  public void testPageDTO() {
      Criteria cri = new Criteria();
      cri.setPageNum(21);
      
      PageDTO pageDTO = new PageDTO(cri, 250);
      log.info(pageDTO);
  }
}
