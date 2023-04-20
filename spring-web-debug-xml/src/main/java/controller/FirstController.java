package controller;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FirstController {

	// 写在当前Controller，则只在这个Controller有用
	// 如果定义全局，查看DateControllerAdvice
	// @InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		// 转换器，由JDK提供的PropertyEditorSupport，可以自定义
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
	}

	@GetMapping("/world")
	@ResponseBody
	public String sayHello(){
		return "hello world!";
	}

	@GetMapping("/date")
	@ResponseBody
	public String date(Date date){
		return date.toString();
	}
}
