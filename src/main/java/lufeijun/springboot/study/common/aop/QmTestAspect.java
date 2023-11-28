package lufeijun.springboot.study.common.aop;

import lufeijun.springboot.study.common.time.MyTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component // 辅助注册一个 bean
@Aspect // 切面
@Order(1) // 若有多个切面类，可以用Order注解决定不同类中的切面的执行顺序值越小越先执行
public class QmTestAspect {

  @Autowired
  private MyTime myTime;

  @Pointcut(value = "execution(*  lufeijun.springboot.study.service.QmService.sayhello(..))")
  public void helloone(){}

  @Pointcut(value = "execution(* lufeijun.springboot.study.service.QmService.sayhello2(..))")
  public void hellotwo(){}

  @Pointcut(value = "execution(* lufeijun.springboot.study.service.QmService.*(..))")
  public void hello(){}

  // 前置通知
  @Before(value = "helloone()")
  public void before(JoinPoint joinPoint) {
    System.out.println("前置通知：处理查询该用户那些权限");
  }


  // 后置通知
  @After(value = "helloone()")
  public void afert() {
    System.out.println("后置通知：处理查询该用户那些权限");
  }

  /**
   * 异常通知（afterThrowing） 当被增强的方法 出现异常之后调用通知
   */
  @AfterThrowing(value = "helloone()",throwing = "e")
  public void afterThrowing(Exception e){
    System.out.println("异常通知：当被增强的方法 出现异常之后调用通知");
    System.out.println("  --"+e.getMessage());
  }

  /**
   * 环绕通知 使用环绕通知后可以不使用Before和after通知
   * proceedingJoinPoint.proceed();的作用是让目标方法执行，@Around = @Before + 方法执行 + @After
   */
  @Around(value = "helloone()")
  public void around(ProceedingJoinPoint proceedingJoinPoint){
    //这里写Before通知的代码
    System.out.println("环绕通知：Before");
    try {
      proceedingJoinPoint.proceed();
    } catch (Throwable throwable) {
      System.out.println("环绕通知：报错信息"+throwable.getMessage());
    }
    //这里写after通知的代码
    System.out.println("环绕通知：after");
  }



  @Before(value = "hellotwo()")
  public void beferetwo() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("前置通知2：处理查询该用户那些权限"+ myTime.getCurrentDatetime());
  }

  @After(value = "hellotwo()")
  public void aferttwo() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("后置通知2：处理查询该用户那些权限"+ myTime.getCurrentDatetime());
  }




}
