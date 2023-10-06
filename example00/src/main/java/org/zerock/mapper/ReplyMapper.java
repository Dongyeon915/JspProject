
package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
    // 댓글 등록 작업
    public int insert(ReplyVO vo);
    
    // 조회 작업
    public ReplyVO read(Long bno);
    
    // 삭제 작업
    public int delete (Long rno);
    
    // 업데이트 작업
    public int update(ReplyVO reply);
    // xml에 파라미터를 전달
    // 특정 게시물의 댓글을 가져오기
    public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
