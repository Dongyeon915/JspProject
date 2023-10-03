package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
    // xml에 정의 했기에 더이상 사용하지 않아도 된다
   // @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();
    // page가져오기
    public List<BoardVO> getListWithPaging(Criteria cri);
    // insert만 처리되고 생성된 PK값을 알 필요가 없는 경우
    public void insert(BoardVO board);
    // insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
    public void insertSelectKey(BoardVO board);
    
    // read처리
    public BoardVO read(Long bno);
    
    // delete 처리 return 타입이 int로 하면 정상적인 삭제가 이루어지면 1이상의 값을 가지도록한다.
    public int delete(Long bno);
    
    // update 처리
    public int update(BoardVO board);
    // 데이터베이스의 실제 모든 게시물수
    public int getTotalCount(Criteria cri);
}
