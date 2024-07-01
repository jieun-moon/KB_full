package ch15.sec02.exam01;

import lombok.*;

//필드 전부를 가지고 있는 생성자를 만들겠다
@AllArgsConstructor
//기본 생성자를 만들겠다
@NoArgsConstructor
//@Getter
//@Setter
//@Data는 getter, setter, toString, 기본 생성자, HashCode, equals가 포함돼있다
@Data

public class Board {
    private String subject;
    private String content;
    private String writer;

//    public Board(String subject, String content, String writer) {
//        this.subject = subject;
//        this.content = content;
//        this.writer = writer;
//    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
}
