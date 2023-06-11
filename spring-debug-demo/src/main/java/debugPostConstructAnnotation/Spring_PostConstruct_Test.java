package debugPostConstructAnnotation;

import config.ConfigC;
import cycle.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring_PostConstruct_Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigC.class);
		Phone a = (Phone)context.getBean("phone");
		System.out.println(a.getName());
		System.out.println(a.getPrice());
	}
}
