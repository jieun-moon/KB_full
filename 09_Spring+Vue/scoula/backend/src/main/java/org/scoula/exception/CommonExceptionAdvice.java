package org.scoula.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdvice: Controller에서 던지는 예외를 받겠다
@ControllerAdvice
@Log4j
//CommonExceptionAdvice: 이 클래스 자체도 controller(지금까지 봤던 Controller 매커니즘 그대로 적용)
public class CommonExceptionAdvice {
    //404 상황
    //@ExceptionHandler: 어떤 예외를 catch 할거야 나타냄
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex){
        return "/resources/index.html";
    }
}
