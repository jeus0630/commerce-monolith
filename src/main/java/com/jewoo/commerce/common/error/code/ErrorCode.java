package com.jewoo.commerce.common.error.code;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String getCode();

    String getMessage();

    HttpStatus getStatus();

}
