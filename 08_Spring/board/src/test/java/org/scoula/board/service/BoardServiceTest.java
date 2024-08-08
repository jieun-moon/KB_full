package org.scoula.board.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.dto.BoardDTO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j
public class BoardServiceTest {

    @Autowired
    private BoardService service;

    @Test
    void getList() {
        //BoardService를 구현한 BoardServiceImple의 getList 호출
//        List<BoardDTO>를 반환한 후 해당 리스트를 순회
        //interface는 구현체가 없지만, 상속받은 하위 리스트를 가져오므로
        for(BoardDTO board: service.getList()){
            log.info(board);
        }
    }

    @Test
    void get() {
//        service > mapper.java
//        mapper.java >
        log.info(service.get(1L));
    }

    @Test
    public void create() {
        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user1");

        service.create(board);

        log.info("생성된 게시물의 번호: " + board.getNo());

    }

    @Test
    public void update() {
        BoardDTO board = service.get(1L); //수정할 게시글 가져오기

        board.setTitle("제목 수정합니다.");
        log.info("update RESULT: " + service.update(board));
    }

    @Test
    void delete() {
        //게시물 번호의 존재 여부를 확인하고 테스트할 것
        log.info("delete RESULT: " + service.delete(2L));
    }
}