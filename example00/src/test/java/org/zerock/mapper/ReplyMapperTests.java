package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
    
    @Autowired
    private ReplyMapper mapper;
    
//    @Test
//    public void testMapper() {
//	log.info(mapper);
//    }
    
//    private Long[] bnoArr = {3147L,3148L};
//    @Test
//    public void testCreate() {
//	IntStream.rangeClosed(1, 10).forEach(i -> {
//	    ReplyVO vo = new ReplyVO();
//	    
//	    vo.setBno(bnoArr[i % 5]);
//	    vo.setReply("댓글테스트" + i);
//	    vo.setReplyer("replyer" + i);
//	    mapper.insert(vo);
//	    
//	});
//    }
    
//    @Test
//    public void testRead() {
//	Long targetRno = 1L;
//	ReplyVO vo = mapper.read(targetRno);
//	log.info(vo);
//    }
    
//    @Test
//    public void testDelete() {
//	Long targetRno = 1L;
//	mapper.delete(targetRno);
//    }
    
    @Test
    public void testUpdate() {
	Long targetRno = 3L;
	
	ReplyVO vo = mapper.read(targetRno);
	vo.setReply("업데이트");
	int count = mapper.update(vo);
	log.info("업데이트 갯수" + count);
    }
}
