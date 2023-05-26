package lufeijun.study.springbootdemo.beans;


import lufeijun.study.springbootdemo.beans.tool.JpHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public JpHelper jpHelper() {
		return new JpHelper("吉鹏");
	}

}
