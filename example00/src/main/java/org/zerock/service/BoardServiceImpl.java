package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
// service를 담당한다는 주요 어노테이션
@Service
@AllArgsConstructor
//처음 파라미터로 객체를 받게된다 service부분이
//BoardServiceImpl -> BoardVO객체 -> BoardMapper를 통해 처리 
public class BoardServiceImpl implements BoardService {
    // 실질적으로 db를 처리해 줘야하기에 mapper는 필수적이다
    @Autowired
    private BoardMapper mapper;
    
    @Override
    public void register(BoardVO board) {
	// 등록작업
	log.info("등록 작업-------" + board);
	
	mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
	log.info("get....." + bno);
	return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
	log.info("수정........" + board);
	return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
	log.info("삭제......." + bno);
	return mapper.delete(bno) == 1;
    }

//    @Override
//    public List<BoardVO> getList() {
//	log.info(" 모든 리스트 가져오기...........");
//	return mapper.getList();
//    }

    @Override
    public List<BoardVO> getList(Criteria cri) {
	log.info("get List with criteria :" + cri);
	return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
	 log.info("get total count");
	return mapper.getTotalCount(cri);
    }

}
