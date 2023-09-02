package org.zerock.mapper;

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
    private BoardMapper boardMapper;

//    @Test
//    public void testGetList() {
//	boardMapper.getList().forEach(board -> log.info(board));
//    }

//    @Test
//    public void testInsert() {
//	BoardVO boardVO = new BoardVO();
//	boardVO.setTitle("새로운 제목");
//	boardVO.setContent("새로운글");
//	boardMapper.insert(boardVO);
//	log.info(boardVO);
//    }

//    @Test
//    public void testRead() {
//	BoardVO boardVO = boardMapper.read(1);
//	log.info("검색결과여기야!");
//	log.info(boardVO);
//    }
//
//    @Test
//    public void testDelete() {
//	log.info("삭제 수행");
//	log.info(boardMapper.delete(2));
//    }
//    
//    @Test
//    public void testUpdate() {
//	BoardVO boardVO = new BoardVO();
//	boardVO.setBno(3);
//	boardVO.setContent("수정한 내용이다");
//	boardVO.setTitle("수정한 제목이다");
//	// int 반환으로 확인가능 삭제 수
//	int count = boardMapper.update(boardVO);
//	log.info("업데이트 한 부분");
//	log.info(count);
//    }
//    
//    @Test
//    public void testPaging() {
//	// 1 10 기본페이지는 생성자로 만들어짐
//	Criteria criteria = new Criteria();
//	
//	List<BoardVO> list = boardMapper.getListWithPaging(criteria);
//	
//	list.forEach(o -> log.info(o));
//    }
    
    @Test
    public void testPageDTO() {
	Criteria criteria = new Criteria();
	criteria.setPageNum(23);
	
	PageDTO pageDTO = new PageDTO(criteria, 20);
	
	log.info(pageDTO);
    }
}
