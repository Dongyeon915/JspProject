package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
    // 해당 메서드가 들어가는 예외 타입을 처리하는 것을 의미한다.
    @ExceptionHandler(Exception.class)
    // String은 return값이 해당 jsp파일의 경로가된다 view까지만 들어간다
    public String except(Exception ex, Model model) {
	log.error("Exception" + ex.getMessage());
	model.addAttribute("exception", ex);
	log.error(model);
	return "error_page";
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex) {
	return "custom404";
    }
}
