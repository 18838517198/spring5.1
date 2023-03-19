package beans;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Hello {
	@Resource
	private Kitty kitty;

	public Kitty getKitty() {
		return kitty;
	}

	public void setKitty(Kitty kitty) {
		this.kitty = kitty;
	}
}
