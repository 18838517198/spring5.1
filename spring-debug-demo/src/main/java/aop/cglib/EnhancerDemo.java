package aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class EnhancerDemo {
	public void test(){
		System.out.println("EnhancerDemo test()");
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(EnhancerDemo.class);
		enhancer.setCallback(new MethodInterceptorImpl());

		EnhancerDemo demo = (EnhancerDemo) enhancer.create();
		demo.test();
		System.out.println(demo);
	}
}
