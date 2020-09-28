package eg.sumitramteke.discount.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceExceptionController {

  @ExceptionHandler(value = ServiceException.class)
  public ResponseEntity<Object> exception(ServiceException exception) {
    return new ResponseEntity<>(exception.getMessage(),  new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
