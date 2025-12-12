package com.emrednmz.exception.handler;

import com.emrednmz.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(ex.getMessage(),request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            if (errors.containsKey(fieldName)) {
               errors.put(fieldName, addValue(errors.get(fieldName),error.getDefaultMessage()));
            } else {
                errors.put(fieldName, addValue(new ArrayList<>(),error.getDefaultMessage()));
            }
        });


        return ResponseEntity.badRequest().body(createApiError(errors,request));

    }

    public <E> ApiError<E> createApiError(E message, WebRequest request) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Exception<E> exception = new Exception<>();
        exception.setMessage(message);
        exception.setTimestamp(new Date());
        exception.setPath(request.getDescription(false));
        exception.setHostname(getHostName());

        apiError.setException(exception);
        return apiError;
    }

    private String getHostName(){
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return  "unknown";
        }
    }

    private List<String> addValue(List<String> list, String value){
        list.add(value);
        return list;
    }

}
