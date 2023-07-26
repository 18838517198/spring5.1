package controller;

import entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
@ControllerAdvice
// RequestBodyAdvice相当于一个切面，处理请求之前调那些方法做一些额外的处理。
// ResponseBodyAdvice 跟AOP很像，但是springmvc自己实现的。写响应体之前我可以额外做一些事情。
// 这些都是一些扩展的机制。初始化的时候看你有没有实现这些接口，如果实现了他就会记录下来。
public class ZhouyuControllerAdvice implements RequestBodyAdvice {
	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {


		System.out.println("accept supports");
		return false;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		System.out.println("beforeBodyRead");
		return null;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		System.out.println("afterBodyRead");
		return null;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		return null;
	}
}
