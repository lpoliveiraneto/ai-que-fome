package br.com.aiquefome.aiquefome.api.handler;

import br.com.aiquefome.aiquefome.domain.exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CozinhaNotFoundException.class)
    public ResponseEntity<Object> handlerCozinhaNotFoundException(CozinhaNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> todosOsErros = ex.getBindingResult().getAllErrors().stream().map(objectError -> {
            Error error = new Error();
            error.setCampo(((FieldError) objectError).getField());
            error.setMensagem(objectError.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());

        return ResponseEntity.status(status).body(todosOsErros);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Object> handlerUsuarioNotFoundException(UsuarioNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(RestauranteNotFoundException.class)
    public ResponseEntity<Object> handlerRestauranteNotFoundException(RestauranteNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EstadoNotFoundException.class)
    public ResponseEntity<Object> handlerEstadoNotFoundException(EstadoNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(CidadeNotFoundException.class)
    public ResponseEntity<Object> handlerCidadeNotFoundException(CidadeNotFoundException exception, WebRequest request) {
        Problema problema = new Problema(LocalDateTime.now(), exception.getMessage(), exception.toString());
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(exception, problema, new HttpHeaders(), status, request);
    }

    public ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(exception, body, headers, status, request);
    }
}
