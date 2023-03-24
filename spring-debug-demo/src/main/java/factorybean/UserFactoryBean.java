package factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component()
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		// 过程很复杂，如大量设置参数，帮助我们完成复杂对象的创建
		// eg: mybatis的SqlSessionFactory
		return new User("楠老师");
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	public void say(){
		System.out.println("hello");
	}
}
