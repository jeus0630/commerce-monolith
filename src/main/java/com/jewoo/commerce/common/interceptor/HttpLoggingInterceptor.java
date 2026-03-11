package com.jewoo.commerce.common.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class HttpLoggingInterceptor implements HandlerInterceptor {

    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);

        log.info(
                "[HTTP_REQUEST] method={} uri={} query={}",
                request.getMethod(),
                request.getRequestURI(),
                request.getQueryString()
        );

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex
    ) {
        Object value = request.getAttribute(START_TIME);
        long startTime = value instanceof Long ? (Long) value : System.currentTimeMillis();
        long duration = System.currentTimeMillis() - startTime;

        if (ex == null) {
            log.info(
                    "[HTTP_RESPONSE] method={} uri={} status={} durationMs={}",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    duration
            );
            return;
        }

        log.error(
                "[HTTP_ERROR] method={} uri={} status={} durationMs={} exception={} message={}",
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus(),
                duration,
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

}
