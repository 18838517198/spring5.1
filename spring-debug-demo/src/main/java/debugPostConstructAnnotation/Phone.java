package debugPostConstructAnnotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Phone {
	private String name;
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@PostConstruct
	public void setFixedName(){
		this.name="三星";
		System.out.println("已调用@PostConstruct注解方法设置手机名称为三星");
	}
}
