package br.com.aiquefome.aiquefome.api.handler;

import br.com.aiquefome.aiquefome.domain.exceptions.CozinhaNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CozinhaNotFoundException.class)
    public ResponseEntity<Object> handlerCozinhaNotFoundException(CozinhaNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    public ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }
}
