package lufeijun.springboot.study.common.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lufeijun.springboot.study.common.response.ResponseBody;
import lufeijun.springboot.study.common.response.ResponseCode;
import lufeijun.springboot.study.exception.MyError;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @SneakyThrows
  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    if(body instanceof String){
      return objectMapper.writeValueAsString(ResponseBody.success(body));
    }

    // 这个行不通，这里属于无用代码了
    if (body instanceof MyError) {
      return ResponseBody.fail(ResponseCode.RC999.getCode(),((Error) body).getMessage());
    }

    if(body instanceof ResponseBody){
      return body;
    }
    return ResponseBody.success(body);

  }
}
