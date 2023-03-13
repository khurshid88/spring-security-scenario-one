package com.springsecurity.scenarioone.exception;

import com.springsecurity.scenarioone.model.CustomResponse;
import com.springsecurity.scenarioone.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionsHandler {

    @ExceptionHandler(value = {CustomApiException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public CustomResponse handleCustomApiException(CustomApiException exception) {
        var errorResponse = ErrorResponse.builder().code(exception.getErrorCode()).description(exception.getMessage()).build();
        return CustomResponse.errorMsg(errorResponse);
    }

}
