package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

 // 현실적인 이름을 붙여야한다. 
public interface BoardService {
    
    public void register(BoardVO board);
    
    public BoardVO get(Long bno);
    
    public boolean modify(BoardVO board);
    
    public boolean remove(Long bno);
    // 페이징 전 
    // public List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);
    
    public int getTotal(Criteria cri);
}
