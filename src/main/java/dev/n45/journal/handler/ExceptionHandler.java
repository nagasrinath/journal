/* (C) 2025 Naga Srinath */
package dev.n45.journal.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler extends ResponseEntityExceptionHandler {
  public static final String INVALID_REQUEST_BODY = "INVALID_REQUEST_BODY";
  public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
}
