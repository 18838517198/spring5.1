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
}
