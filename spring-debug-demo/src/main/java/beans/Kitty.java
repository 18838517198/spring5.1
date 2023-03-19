package beans;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Kitty {
	@Resource
	private Hello hello;

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}
}
