package controller;

import entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {

	@RequestMapping("paramTest1")
	public String paramTest1(@RequestParam("no") String no, @RequestParam("name") String name){
		return "no :"+no+",name: "+name;
	}

	@RequestMapping("objTest1")
	public String objTest1(User user){
		return user.getUserName();
	}

	@PostMapping(value="bodyTest1")
	public String bodyTest1(@RequestBody String name){
		return name;
	}

	@PostMapping(value="bodyTest2")
	public String bodyTest2(@RequestBody User user){
		return user.getUserName();
	}
}
