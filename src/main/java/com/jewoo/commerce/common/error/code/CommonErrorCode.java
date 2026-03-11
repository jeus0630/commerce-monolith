package com.jewoo.commerce.common.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "Method Not Allowed"),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "C003", "Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C004", "Internal Server Error"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C005", "Bad Request"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "C006", "Forbidden"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "C007", "Unauthorized");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
