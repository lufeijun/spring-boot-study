package lufeijun.springboot.study.service.impl;

import jakarta.annotation.Resource;
import lufeijun.springboot.study.common.time.MyTime;
import lufeijun.springboot.study.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
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

//    Future<String> submit = asyncCustom.submit(runnable);
//    Future<?> submit1 = asyncCustomTwo.submit(runnable);
//    Future<?> submit2 = threadPoolTaskExecutor.submit(runnable);
    Future<String> submit = asyncCustom.submit(() -> {
      test(111);
      return "OK";
    });

  }

  @Override
  public void TheCompletableFuture() {

    myTime.ShowSysLogDatetime("TheCompletableFuture start");

    // completableFutureOne();
    completableFutureTwo();

    myTime.ShowSysLogDatetime("TheCompletableFuture end");
  }

  private void completableFutureOne() {
    // 创建异步任务
    CompletableFuture<String> objectCompletableFuture5 = CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(5000);
        return "ok";
      } catch (InterruptedException e) {
        return "no";
      }
    });

    // 调用异步任务
    objectCompletableFuture5.thenAccept(result -> {
      // 处理异步任务的结果
      myTime.ShowSysLogDatetime("TheCompletableFuture 异步");
      System.out.println(result);
    });
  }

  private void completableFutureTwo(){
    CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(5000);
        myTime.ShowSysLogDatetime("cp1 5s 异步");
        return "cp1 yes";
      } catch (InterruptedException e) {
        return "cp1 no";
      }
    });

    CompletableFuture<String> cp2 = CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(10000);
        myTime.ShowSysLogDatetime("cp2 10s 异步");
        return "cp2 yes";
      } catch (InterruptedException e) {
        return "cp2 no";
      }
    });

    try {
      String s1 = cp1.get();
      String s2 = cp2.get();
      myTime.ShowSysLogDatetime("cp1 和 cp2 完成：" + s1 + "===" + s2);
    } catch (Exception e) {
      System.out.println("completableFutureTwo 异步失败");
    }

  }


}
