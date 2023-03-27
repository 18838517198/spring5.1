package beans;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	private String dog;

	public String getDog() {
		return dog;
	}

	public void setDog(String dog) {
		this.dog = dog;
	}


	@Override
	public String toString() {
		return "Dog{" +
				"dog='" + dog + '\'' +
				'}';
	}
}
