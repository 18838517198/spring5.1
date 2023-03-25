package aop.demo1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SunWuKongProxy {

	@Before("execution(* aop.demo1.SunWuKong.JinDouYun())")
	public void QiShiErBian(){
		System.out.println("孩儿们，老孙回来啦！");
	}

	@After("execution(* aop.demo1.SunWuKong.JinDouYun())")
	public void JinGuBang(){
		System.out.println("呔！吃俺老孙一棒！");
	}
}
