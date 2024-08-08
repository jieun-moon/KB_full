package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//Transaction 처리를 해달라(but, 단위테스트에서는 다름
//test 과정에서 데이터 넣고 수정 -> 테스트용(운영에서는 무쓸모)
//단위테스트에 붙으면: 정상적으로 끝났을 때 Rollback
//create가 성공해도 단위테스트끝나면 자동으로 Rollback됨
//실제 data에 영향을 주지 않기 위해서 사용
//실제로 data에 영향을 주려면 @Transactional 주석 처리해서 운영
@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    public void getList() {
//        모든 BoardVO 리스트를 가져와서 각 객체를 출력한다
        for(BoardVO board: mapper.getList()){
            log.info(board);
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    public void get() {
        //존재하는 게시물 번호로 테스트
        BoardVO board = mapper.get(10L);

        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의 새글 작성")
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글xx");
        board.setContent("새로 작성하는 내용xxx");
        board.setWriter("user0");

        mapper.create(board);

        log.info(board);
    }

//5L: L은 Long
    @Test
    @DisplayName("BoardMapper의 글 수정")
    public void update() {
        BoardVO board = new BoardVO();
//        no에는 존재하는 no값을 적어줘야 제대로 수정이 된다
        board.setNo(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        //count에는 수정된 행의 수를 반환
        int count = mapper.update(board);

        log.info("UPDATE COUNT: " + count);
    }

    @Test
    @DisplayName("BoardMapper의 글 삭제")
    public void delete() {
        log.info("DELETE COUNT: " + mapper.delete(3L));
    }
}