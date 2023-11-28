package lufeijun.springboot.study.common.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {
  public String getCurrentDatetime() {
    SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
    sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();// 获取当前时间
    return sdf.format(date);
  }

}
