package lufeijun.study.springbootdemo.beans.tool;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过名字获取
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	// 通过类获取
	public static <T> T getBean(Class<T> cla) {
		return getApplicationContext().getBean(cla);
	}

	// 通过 name，以及 class 获取
	public static <T> T getBean(String name , Class<T> cla){
		return getApplicationContext().getBean(name, cla);
	}

}
