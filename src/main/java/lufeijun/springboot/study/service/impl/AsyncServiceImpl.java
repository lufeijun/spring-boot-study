package lufeijun.springboot.study.service.impl;

import jakarta.annotation.Resource;
import lufeijun.springboot.study.common.time.MyTime;
import lufeijun.springboot.study.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Service
public class AsyncServiceImpl implements AsyncService {

  @Resource
  private ThreadPoolTaskExecutor asyncCustom;

  @Resource
  private ThreadPoolTaskExecutor asyncCustomTwo;
//
//  @Resource
//  private ThreadPoolTaskExecutor threadPoolTaskExecutor;

  @Autowired
  private MyTime myTime;

  @Override
  @Async
  public void index() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("AsyncServiceImpl index" + myTime.getCurrentDatetime());
  }

  @Override
  @Async("asyncCustom")
  public void custom(int i) {
    try {
      test(i);
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("AsyncServiceImpl custom== " + i + "==线程名称：" + Thread.currentThread().getName() + "==" + myTime.getCurrentDatetime());
  }

  private void test(int i) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("AsyncServiceImpl custom:test== " + i + "==线程名称：" + Thread.currentThread().getName() + "==" + myTime.getCurrentDatetime());
  }


  @Override
  public void autowired() {

    Runnable runnable = () -> {
      try {
        test(111);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };

    Future<?> submit = asyncCustom.submit(runnable);
    Future<?> submit1 = asyncCustomTwo.submit(runnable);
//    Future<?> submit2 = threadPoolTaskExecutor.submit(runnable);

  }

}
