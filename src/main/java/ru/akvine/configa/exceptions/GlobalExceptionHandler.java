package ru.akvine.configa.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.akvine.configa.exceptions.app.AppNotFoundException;
import ru.akvine.configa.exceptions.client.ClientNotFoundException;
import ru.akvine.configa.rest.dto.common.ErrorResponse;

import static ru.akvine.configa.exceptions.CommonErrorCodes.GENERAL_ERROR;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ErrorResponseBuilder errorResponseBuilder;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = errorResponseBuilder
                .build(GENERAL_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity handleClientNotFoundException(ClientNotFoundException exception) {
        ErrorResponse errorResponse = errorResponseBuilder
                .build(CommonErrorCodes.Client.CLIENT_NOT_FOUND_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AppNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleAppNotFoundException(AppNotFoundException exception) {
        ErrorResponse errorResponse = errorResponseBuilder.build(CommonErrorCodes.App.APP_NOT_FOUND_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
