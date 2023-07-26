import beans.Dog;
import config.ConfigC;
import cycle.A;
import debug.debugValueAnnotation.ValueA;
import debug.debugValueAnnotation.ValueB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigC.class);
		ValueA a = (ValueA)context.getBean("valueA");
		System.out.println(a.getName());
		ValueB b = (ValueB) context.getBean("valueB");
		System.out.println(b.getName());
	}
}
