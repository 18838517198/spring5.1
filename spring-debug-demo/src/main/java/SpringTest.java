import beans.Dog;
import config.ConfigC;
import cycle.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigC.class);
		A a = (A)context.getBean("a");
		a.hello();
	}
}
