package debug.debugValueAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueA {
	private String name;

	public ValueA(@Value("${a_name}") String name) {
		this.name = name;
		System.out.println("构造方法ValueA已设置name值:"+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
