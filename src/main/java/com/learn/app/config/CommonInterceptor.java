package com.learn.app.config;

import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

/**
 * Disadvantages :
 * 1. Can't read request body as
 * */
@Slf4j
public class CommonInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("Received a Request : {}", request.getPathInfo());

    // Update MDC with trackingId
    String trackingId = request.getHeader("tracking-id");
    MDC.put("parent-tracking-id", request.getHeader("parent-tracking-id"));
    MDC.put("tracking-id", trackingId != null?trackingId : UUID.randomUUID().toString());

    if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
        && (request.getMethod().equals(HttpMethod.POST.name())
            || request.getMethod().equals(HttpMethod.PUT.name()))) {

//      Note : Bellow code will not work as we can read input stream once
//      String requestStr = IOUtils.toString(request.getInputStream());
//      log.info("request body {}", requestStr);
    }

    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
