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

DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment (
    no INTEGER AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(256) NOT NULL, -- 원본 파일 명
    path VARCHAR(256) NOT NULL, -- 서버에서의 파일 경로
    content_type VARCHAR(56), -- content-type
    size INTEGER, -- 파일의 크기
    bno INTEGER NOT NULL, -- 게시글 번호, FK
    reg_date DATETIME DEFAULT now(),
    CONSTRAINT FOREIGN KEY(bno) REFERENCES tbl_board(no)
);