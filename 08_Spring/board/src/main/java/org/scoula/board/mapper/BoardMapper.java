package org.scoula.board.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    //BoardVO map(ResultSet rs)를 Mybatis가 자동으로 해줌
    //원리는 Spring DI와 같음
    //*이 setxxx()에 의해서 결정됨.
    //select no => setNo
    //select title => setTitle
    //    tbl_board 테이블에서 모든 컬럼을 no 컬럼 기준으로 내림차순 정렬
    //@Select("select * from tbl_board")
//    BoardVO객체의 리스트를 반환
    public List<BoardVO> getList();

    //Long no: 이 값을 어떻게 sql에 넣을 건가?
//    특정 번호(no)에 해당하는 BoardVO 객체 반환
    public BoardVO get(Long no);

//    새로운 BoardVO 게시물을 생성
    public void create(BoardVO board);

//    기존에 있는 게시글을 업데이트(수정)
    public int update(BoardVO board);

//    해당 no 값을 가진 게시글을 삭제
    public int delete(Long no);
}
