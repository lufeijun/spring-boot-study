package lufeijun.springboot.study.common.email;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class MyEmail {

  // 异步
  @Resource
  private ThreadPoolTaskExecutor asyncCustom;

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.from}")
  private String from;

  /**
   *
   * @param to   接收人
   * @param subject 主题
   * @param content 内容
   */
  public void sendSimpleMail(String to, String subject, String content) {
    Runnable runnable = () -> {
      try {
        _sendSimpleMail(to,subject,content);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };

    Future<?> submit = asyncCustom.submit(runnable);
  }

  private void _sendSimpleMail(String to, String subject, String content) {

    System.out.println("===========sendSimpleMail start==============");

    var message = new SimpleMailMessage();

    // 设置参数
    message.setFrom(from);
    message.setTo(to);

    message.setSubject(subject);
    message.setText(content);

    try {
      javaMailSender.send(message);
      System.out.println("发送成功");
    } catch ( Exception e ) {
      System.out.println("发送失败"+e.getMessage());
    }

    System.out.println("===========sendSimpleMail end==============");

  }





}
