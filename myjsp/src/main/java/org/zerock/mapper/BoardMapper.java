package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
    
  //  @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();
    
    public void insert(BoardVO boardVO);
    
    public BoardVO read(int bno);
    // 삭제시 1의 값을 확인 return int
    public int delete(int bno);
    
    public int update(BoardVO boardVO);

}
