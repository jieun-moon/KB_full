package org.scoula.ex05.dto;

public class LoginDTO { //Getter, Setter, 필드, 생성자 가지고 있으면 Java Bean으로 사용 가능(객체랑 다를바 없음)
    private String name; //attribute, 기본적으로 바깥에서 접근하기 힘듦
    private String passwd;

    public LoginDTO() {
    }

    public LoginDTO(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    //EL에서 말하는 property는 getter를 말함
    //아래 코드를 주석 처리하면 아래와 같은 에러 메세지가 뜸
    //javax.el.PropertyNotFoundException: [org.scoula.ex05.dto.LoginDTO] 유형에서 [name] 특성을 읽을 수 없습니다.
    public String getName() { //property, getter/setter를 통해서 바깥에서 접근 가능
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
