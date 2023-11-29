package lufeijun.springboot.study.exception;

public class MyError extends Error{

  public MyError(String msg) {
    super(msg);
  }
}
