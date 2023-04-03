package easy;

import org.springframework.beans.factory.BeanFactory;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		System.out.println(set.add("hello"));
		System.out.println(set.add("hello"));
	}
}
