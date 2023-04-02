package easy;

import org.springframework.beans.factory.BeanFactory;

public class StringTest {
	public static void main(String[] args) {
		String beanName = "&&&pan";
		do {
			beanName = beanName.substring(BeanFactory.FACTORY_BEAN_PREFIX.length());
		}
		// 如果beanName以&开头，继续循环
		while (beanName.startsWith(BeanFactory.FACTORY_BEAN_PREFIX));
		System.out.println(beanName);
	}
}
