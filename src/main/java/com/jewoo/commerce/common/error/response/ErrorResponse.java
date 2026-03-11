package com.jewoo.commerce.common.error.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jewoo.commerce.common.error.response.FieldErrorDetail;
import com.jewoo.commerce.common.error.code.ErrorCode;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErrorResponse(
        Instant timestamp,
        String code,
        String message,
        List<FieldErrorDetail> errors
) {
    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(
                Instant.now(),
                errorCode.getCode(),
                errorCode.getMessage(),
                List.of()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, String message) {
        return new ErrorResponse(
                Instant.now(),
                errorCode.getCode(),
                message,
                List.of()
        );
    }

    public static ErrorResponse of(ErrorCode errorCode, List<FieldErrorDetail> errors) {
        return new ErrorResponse(
                Instant.now(),
                errorCode.getCode(),
                errorCode.getMessage(),
                errors
        );
    }
}
