package lufeijun.springboot.study.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import lufeijun.springboot.study.common.response.ResponseBody;
import lufeijun.springboot.study.common.response.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

  /**
   * 全局异常
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseBody<String> exception(Exception e) {
    System.out.println("Exception");
    log.error("系统报错：", e.getMessage(), e);
    return ResponseBody.fail(ResponseCode.RC500.getCode(), ResponseCode.RC500.getMessage());
  }


  /**
   * 业务逻辑错误提示
   */
  @ExceptionHandler(MyRuntimeException.class)
  public ResponseBody<String> business(Exception e) {
    System.out.println("MyRuntimeException");
    return ResponseBody.fail(ResponseCode.RC999.getCode(), e.getMessage());
  }

  /**
   * 参数验证
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseBody<String> violation(Exception e) {
    return ResponseBody.fail(ResponseCode.RC998.getCode(), e.getMessage());
  }


  /**
   * 构造返回数据，好像也不需要，本来也就是一层调用关系而已
   */
  private ResponseBody<String> initResponseBody(Exception e) {
    return ResponseBody.fail(ResponseCode.RC998.getCode(), e.getMessage());
  }

}