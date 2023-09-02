package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

// 비즈니스 계층은 고객과의 의사소통을 위한 이름으로 변수이름작성
public interface BoardService {
    
   public int register(BoardVO boardVO);
   
   public BoardVO get(int bno);
   
   public int modify(BoardVO boardVO);
   
   public int remove(int bno);
   
   public List<BoardVO> getList();
   
   public List<BoardVO> getList(Criteria criteria);
}
