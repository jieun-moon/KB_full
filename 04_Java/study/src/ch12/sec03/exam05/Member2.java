package ch12.sec03.exam05;

import lombok.*;

//안쓰고 있는 import 삭제: ctrl + alt + o
//@Data: RequiredArgsConstructor, Getter, Setter, Equals, Hashcode, ToString 메소드 모두 포함
//@NoArgsConstructor: 기본 생성자 만들어줌
//@AllArgsConstructor: 모든 필드 포함시키는 생성자 만들어줌
//아래 세개가 가장 많이 쓰임
//덧붙이면 Builder까지
//Builder는 AllArgsConstructor를 기반으로 만들어짐
//여러개의 생성자를 기반으로 Builder가 만들어짐
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member2 {
    private String id;
//    @NonNull: null이면 안 되는 필수 항목,
//    따라서 @RequiredArgsConstructor에 의해 해당 필드를 포함하는 생성자가 만들어진다
    @NonNull
    private String name;
    private int age;
}
