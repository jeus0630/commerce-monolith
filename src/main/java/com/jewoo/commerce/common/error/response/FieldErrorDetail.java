package com.jewoo.commerce.common.error.handler;

public record FieldErrorDetail(
        String field,
        Object value,
        String reason
) {

}
