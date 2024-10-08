package org.scoula.security.handler;


import lombok.extern.slf4j.Slf4j;
import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accesssDeniedException) throws IOException, ServletException{
        log.error("============== 인가 에러 ==============");

//        접근 거부에 대한 응답을 JSON 형태로 보낸다
        JsonResponse.sendError(response, HttpStatus.FORBIDDEN, "권한이 부족합니다.");
//        HttpStatus.FORBIDDEN: 403에러*+9
    }
}
