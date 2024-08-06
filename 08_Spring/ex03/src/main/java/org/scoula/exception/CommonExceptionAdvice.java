package org.scoula.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdvice: Controller에서 던지는 예외를 받겠다
@ControllerAdvice
@Log4j
//CommonExceptionAdvice: 이 클래스 자체도 controller(지금까지 봤던 Controller 매커니즘 그대로 적용)
public class CommonExceptionAdvice {
    //@ExceptionHandler: 경로 대신에 catch할 예외 제시
    //Exception 캐치할거다.(모든 예외는 Exception이 처리하겠다는 뜻)
    @ExceptionHandler(Exception.class)
    public String except(Exception ex, Model model){
        log.error("Exception ......" + ex.getMessage());
        model.addAttribute("exception", ex);
        log.error(model);
        //return "error_page": /error_page.jsp로 가겠다
        return "error_page";
    }

    //404 상황
    //@ExceptionHandler: 어떤 예외를 catch 할거야 나타냄
    @ExceptionHandler(NoHandlerFoundException.class)
    //HttpStatus: enumerate. 모든 응답처리에 대해 상수 처리
    //NOT_FOUND: 404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex){
        return "custom404";
    }
}
