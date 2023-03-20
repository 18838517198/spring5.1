一般情况下，Spring通过反射机制利用bean的class属性指定实现类来实例化bean。
如果按照传统方式，实例化bean则需要在<bean>中提供大量的配置信息，灵活性是受限的，
这时采用编码的方式可能会得到一个简单的方案。
Spring为此提供了一个org.SpringFramework.bean.factory.FactoryBean的工厂类接口，
用户可以通过实例该接口定制实例化 bean的逻辑。
Spring自身就提供了70多个FactoryBean的实现。它们隐藏了实例化一些复杂bean的细节，给
上层应用带来了遍历。从Spring3.0开始，FactoryBean开始支持泛型:FactoryBean<T>
public interface FactoryBean<T>{
  T getObject() throws Exception; 
  Class<?> getObjectType();
  boolean isSingleton();
}
当配置文件<bean>的class属性配置的实现类是FactoryBean时，通过getBean()方法返回的不是
FactoryBean本身，而是FactoryBean#getObject()方法所返回的对象，相当于FactoryBean#
getObject()代理了getBean()方法。
例如: public class CarFactoryBean implements FactoryBean<Car>
如果希望获取CarFactoryBean的实例，则需要在使用getBean(beanName)方法时在beanName前显式的
加上"&"前缀，例如getBean("&car")。