package br.com.calto.vendas_online.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  // /**
  //  * Handle MissingServletRequestParameterException. Triggered when a 'required' request parameter is missing.
  //  *
  //  * @param ex      MissingServletRequestParameterException
  //  * @param headers HttpHeaders
  //  * @param status  HttpStatus
  //  * @param request WebRequest
  //  * @return the ApiError object
  //  */
  // @Override
  // protected ResponseEntity<Object> handleMissingServletRequestParameter(
  //   MissingServletRequestParameterException ex,
  //   HttpHeaders headers,
  //   HttpStatus status,
  //   WebRequest request
  // ) {
  //   String error = ex.getParameterName() + " parameter is missing";
  //   ApiError apiError = new ApiError(BAD_REQUEST);
  //   apiError.setMessage(error);
  //   return buildResponseEntity(apiError);
  // }
}
