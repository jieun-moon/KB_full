package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //로그인 체크
        //getParameter 내에 있는 이름은 input의 name과 같은지 확인할 것
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        //위에서 만들어진 변수 정보를 request 내에 세팅한다
        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);


        request.setAttribute("login", loginDTO);

        //ScopeServlet에서 가져온 로그인 처리
        HttpSession session = request.getSession();
        Member member = new Member("홍길동", userid);
        session.setAttribute("user", member);

        //설정한 request를 login.jsp로 보내서 화면을 띄워준다
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

//1) 파라미터 추출 => 1단계에서 잘못됐다면, 정보 전달을 잘못한 것 => 400에러(클라이언트 잘못)
//2) B.L 실행 => 에러: 정보는 제대로 전달했으나 죽었다. 예외 발생(버그) => 500에러(internal server) 서버 잘못(개발자 잘못)
//3) 결과 request scope 저장 => 에러 날 일 거의 없음
//4) forwarding/redirect => 가끔 jsp 경로 잘못 적어서 에러 나는 정도 => 404에러(이런 JSP 파일 없어 에러)
