package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
    
    @Autowired
    private ReplyMapper mapper;

    @Override
    public int register(ReplyVO vo) {
	log.info("등록" + vo);
	return mapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long rno) {
	log.info("댓글 조회" + rno);
	return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVO vo) {
	log.info("수정중" + vo);
	return mapper.update(vo);
    }

    @Override
    public int remove(Long rno) {
	log.info("삭제중" + rno);
	return mapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
	// TODO Auto-generated method stub
	return mapper.getListWithPaging(cri, bno);
    }

}
