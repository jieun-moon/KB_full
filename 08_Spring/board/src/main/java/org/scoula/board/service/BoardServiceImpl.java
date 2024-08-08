package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@Service //Service 역할을 하는 Bean 등록
@RequiredArgsConstructor //final 필드로 생성자 추가
public class BoardServiceImpl implements BoardService {
    //final 멤버가 붙은 인자에 대해 생성자를 만들어주겠다
    //생성자가 하나 있다면 그 생성자로 주입 가능
    final private BoardMapper mapper;


    @Override
    public List<BoardDTO> getList() {
        log.info("getList...........");
//            mapper.getList(): List<BoardVO>를 원함
//        map: 모양을 변환(돌면서 요소 변환). BoardVO => BoardDTO로 변환
            return mapper.getList().stream() //BoardVO의 스트림
                    .map(BoardDTO::of) //전부 BoardDTO로 변환 -> BoardDTO의 stream
                    .toList(); //BoardDTO의 리스트로 변환(List<BoardDTO>변환)
    }
    //위의 코드에 pagination 기능을 구성해야함

    @Override
    public BoardDTO get(Long no) {
        log.info("get..........." + no);

        //null이 아닌 경우 .of
        //null이 아닌지 확신이 없을 경우 .ofNullable()
        //NoSuchElementException::new = RuntimeException
        //데이터 베이스에 없는 Long no 발생시켰을 때 예외 발생
        BoardDTO board = BoardDTO.of(mapper.get(no));
        //만약 board 객체가 null이면 "NoSuchElementException::new"예외 발생, null이 아니면 해당 객체 반환
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void create(BoardDTO board) {

        log.info("create......" + board);
//DTO를 VO로 변경해서 mapper의 메소드 호출
        BoardVO vo = board.toVo();
        mapper.create(vo);
//        변경된 vo의 no를 가져와서 다시 dto에 반영
        //no은 DTO객체가 아닌 VO에 들어감
        board.setNo(vo.getNo());
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update......" + board);

//        transaction처리가 필요하므로 나중에 @Transational 불여야함
//        지금은 하나뿐이라 할 필요 없음
//        mapper의 update를 호출해서 수정된 행의 수가 1일 경우 true 반환
        return mapper.update(board.toVo()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete......" + no);

//        삭제된 행의 수가 1인지 확인해서 boolean반환
        return mapper.delete(no) == 1;
    }
}
