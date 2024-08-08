# tbl_board 테이블이 존재하면 삭제
DROP TABLE IF EXISTS tbl_board;

# tbl_board 테이블 생성
CREATE TABLE tbl_board (
    no          INTEGER AUTO_INCREMENT PRIMARY KEY, -- PRIMARY KEY: 클러스터형 index
    title       VARCHAR(200) NOT NULL,
    content     TEXT, -- 길이 제한이 없음
    writer      VARCHAR(50) NOT NULL, -- 나중에 Foreign Key
    reg_date    DATETIME DEFAULT CURRENT_TIMESTAMP, -- 등록 날짜
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP -- 수정 날짜
);

# tbl_board 테이블에 데이터를 삽입
# 행 추가
INSERT INTO tbl_board (title, content, writer)
VALUES
    ('테스트 제목 1', '테스트 내용 1', 'user00'),
    ('테스트 제목 2', '테스트 내용 2', 'user00'),
    ('테스트 제목 3', '테스트 내용 3', 'user00'),
    ('테스트 제목 4', '테스트 내용 4', 'user00'),
    ('테스트 제목 5', '테스트 내용 5', 'user00');

SELECT * FROM tbl_board order by no desc;