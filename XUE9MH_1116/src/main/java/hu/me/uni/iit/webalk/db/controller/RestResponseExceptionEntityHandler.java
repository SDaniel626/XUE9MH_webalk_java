package hu.me.uni.iit.webalk.db.controller;

import hu.me.uni.iit.webalk.db.service.NoSuchEntityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchEntityException.class)
    protected ResponseEntity<Object> handleNoSuchElement(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex,ex.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }
}
