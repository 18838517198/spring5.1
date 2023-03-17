import beans.Dog;
import config.ConfigC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigC.class);
		Dog dog = (Dog)context.getBean("dog");
		System.out.println(dog);
	}
}
