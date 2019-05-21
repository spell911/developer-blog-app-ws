package com.developerblog.app.ws.developerblogappws.exception;

import java.util.Date;

import com.developerblog.app.ws.developerblogappws.ui_model_response.ErrorMessage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    // ANY EXCEPTION
    public ResponseEntity<Object> handlerAnyException(Exception ex, WebRequest webRequest) {
        String errorDescription = ex.getLocalizedMessage();
        if (errorDescription == null)
            errorDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // // NULL POINTER EXCEPTION
    // @ExceptionHandler(value = { NullPointerException.class })
    // public ResponseEntity<Object> handlerNullPointeException(NullPointerException
    // ex, WebRequest webRequest) {
    // String errorDescription = ex.getLocalizedMessage();
    // if (errorDescription == null)
    // errorDescription = ex.toString();
    // ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
    // return new ResponseEntity<>(errorMessage, new HttpHeaders(),
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    // // USER SERVICE EXCEPTION
    // @ExceptionHandler(value = { UserServiceException.class })
    // public ResponseEntity<Object>
    // handlerUserServiceException(UserServiceException ex, WebRequest webRequest) {
    // String errorDescription = ex.getLocalizedMessage();
    // if (errorDescription == null)
    // errorDescription = ex.toString();
    // ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
    // return new ResponseEntity<>(errorMessage, new HttpHeaders(),
    // HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    // SPECIFIC EXCEPTION
    @ExceptionHandler(value = { UserServiceException.class, NullPointerException.class })
    public ResponseEntity<Object> handlerSpacificeException(Exception ex, WebRequest webRequest) {
        String errorDescription = ex.getLocalizedMessage();
        if (errorDescription == null)
            errorDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}