package lufeijun.springboot.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池
 *  1、如果需要多个，可以定义多个 bean
 */

@Configuration
@EnableAsync
public class AsyncConfig {

  @Bean("asyncCustom")
  public ThreadPoolTaskExecutor asyncCustom() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    // 这些参数可以放配置文件中

    // 核心线程数
    executor.setCorePoolSize(10);
    // 最大线程数
    executor.setMaxPoolSize(10);
    // 任务队列大小
    executor.setQueueCapacity(1);

    // 设置线程名称前缀
    executor.setThreadNamePrefix("async-custom");

    // 允许线程空闲时间
    executor.setKeepAliveSeconds(300);


    executor.setWaitForTasksToCompleteOnShutdown(true);
    executor.setAwaitTerminationSeconds(60);

    // 拒绝处理策略
//    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

    // 线程异常捕获
//    executor.

    // 线程初始化
    executor.initialize();

    return executor;
  }


  @Bean("asyncCustomTwo")
  public ThreadPoolTaskExecutor asyncCustomTwo() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    // 这些参数可以放配置文件中

    // 核心线程数
    executor.setCorePoolSize(10);
    // 最大线程数
    executor.setMaxPoolSize(10);
    // 任务队列大小
    executor.setQueueCapacity(1);

    // 设置线程名称前缀
    executor.setThreadNamePrefix("async-custom-two");

    // 允许线程空闲时间
    executor.setKeepAliveSeconds(300);

    // 等待任务执行完成再重启
    executor.setWaitForTasksToCompleteOnShutdown(true);
    executor.setAwaitTerminationSeconds(60);

    // 拒绝处理策略
//    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

    // 线程异常捕获
//    executor.

    // 线程初始化
    executor.initialize();

    return executor;
  }


}
