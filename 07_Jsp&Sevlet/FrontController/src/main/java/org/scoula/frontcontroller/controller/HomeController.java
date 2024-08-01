package org.scoula.frontcontroller.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController {
    //POJO로 상속받는 것X
    //참조를 통해서 맞출 거기 때문에 interface 구현할 필요 없음
    //대신 메서드 모양(매개변수&리턴타입)이 command interface와 맞아야 함(메서드명은 맞을 필요 없음)
    public String getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //view 이름: index
        return "index";
    }
}
