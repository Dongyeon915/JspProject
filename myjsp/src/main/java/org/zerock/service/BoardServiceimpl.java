package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceimpl  implements BoardService{
   // mapper주입으로 db처리
    private final BoardMapper boardMapper;

    @Override
    public int register(BoardVO boardVO) {	
	return boardMapper.insert(boardVO);		
    }

    @Override
    public BoardVO get(int bno) {
	return boardMapper.read(bno);
    }

    @Override
    public int modify(BoardVO boardVO) {
	return boardMapper.update(boardVO);
    }

    @Override
    public int remove(int bno) {
	return boardMapper.delete(bno);
    }

    @Override
    public List<BoardVO> getList() {
	return boardMapper.getList();
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
	return boardMapper.getListWithPaging(criteria);
    }

  
}
