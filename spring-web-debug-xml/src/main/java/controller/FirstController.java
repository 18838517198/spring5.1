package controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FirstController{

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
	public String sayHello(){
		return "hello world!";
	}

//	@ModelAttribute("user")
//	public String addString(@RequestParam("user") String value){
//		return value;
//	}

	@GetMapping("/date")
	@ResponseBody
	public String date(Date date, Model model){
		return model.toString();
	}

	@GetMapping("/hello/{id}")
	@ResponseBody
	public String test(@RequestAttribute("XXX") String id){
		return "hello world! "+id;
	}

}
