package factorybean;

import beans.Dog;
import config.ConfigC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyFactoryBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigC.class);
		User user = (User)context.getBean("userFactoryBean");
		UserFactoryBean userFactoryBean = (UserFactoryBean)context.getBean("&userFactoryBean");
		System.out.println(user);
		userFactoryBean.say();
	}
}
