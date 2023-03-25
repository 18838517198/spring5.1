package aop.demo1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class ProxyContext {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProxyConfig.class);
		SunWuKong sunWuKong = (SunWuKong) context.getBean("sunWuKong");
		sunWuKong.JinDouYun();
	}
}
