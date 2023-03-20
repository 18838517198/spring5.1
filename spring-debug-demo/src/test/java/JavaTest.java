import beans.Dog;
import entities.Weaker;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class JavaTest {
	public static void main(String[] args) {
		Set<String> singletonsCurrentlyInCreation =
				Collections.newSetFromMap(new ConcurrentHashMap<>(16));
		singletonsCurrentlyInCreation.contains("Dog");
		System.out.println(singletonsCurrentlyInCreation.size());
	}

	@Test
	public void test1(){
		Weaker weaker = new Weaker();
		weaker.walk(()->{
			System.out.println("我在行走2");
		});
	}

	@Test
	public void test2(){
		//获取系统类加载器
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@4e0e2f2a

		//获取其上层，扩展类加载器
		ClassLoader extClassLoader = systemClassLoader.getParent();
		System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@1055248e

		//获取其上层: 获取不到引导类加载器
		ClassLoader bootstrapClassLoader = extClassLoader.getParent();
		System.out.println(bootstrapClassLoader);//null

		//对于用户自定义类来说:默认使用系统类加载器进行加载
		ClassLoader classLoader = JavaTest.class.getClassLoader();
		System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@4e0e2f2a

		//String类使用引导类加载器进行加载的。---->Java的核心类库都是使用引导类加载器进行加载的
		ClassLoader classLoader1 = String.class.getClassLoader();
		System.out.println(classLoader1);//null
	}
}
