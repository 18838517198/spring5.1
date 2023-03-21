package aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test implements BeanFactoryAware {
	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
	}

	public void testAware(){
		//通过hello这个bean id 从beanFactory获取实例
		Hello hello = (Hello) beanFactory.getBean("hello");
		hello.say();
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Hello.class,Test.class);
		Test test = (Test)context.getBean("test");
		test.testAware();
	}
}
