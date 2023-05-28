package cycle;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCycleTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cycle.xml");
		A bean = ac.getBean(A.class);
		System.out.println(bean.getB());
		B bean1 = ac.getBean(B.class);
		System.out.println(bean1.getA());
	}


}
