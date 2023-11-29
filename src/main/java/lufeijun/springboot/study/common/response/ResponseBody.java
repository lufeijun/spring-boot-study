package lufeijun.springboot.study.common.response;

import lombok.Data;

@Data
public class ResponseBody<T> {
  private int status;
  private String message;
  private T data;

  public static <T> ResponseBody<T> success(T data) {
    ResponseBody<T> responseBody = new ResponseBody<>();
    responseBody.setStatus(ResponseCode.RC0.getCode());
    responseBody.setMessage(ResponseCode.RC0.getMessage());
    responseBody.setData(data);
    return responseBody;
  }

  public static <T> ResponseBody<T> fail(int code, String message) {
    ResponseBody<T> responseBody = new ResponseBody<>();
    responseBody.setStatus(code);
    responseBody.setMessage(message);
    return responseBody;
  }


}
