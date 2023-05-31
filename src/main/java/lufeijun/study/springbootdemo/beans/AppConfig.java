package lufeijun.study.springbootdemo.beans;


import lufeijun.study.springbootdemo.beans.tool.JpHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 配置类
public class AppConfig {

	/**
	 * bean 默认是单实例
	 * @return
	 */
	@Bean // 表明是一个组件
	public JpHelper jpHelper() {
		return new JpHelper("吉鹏");
	}

}
