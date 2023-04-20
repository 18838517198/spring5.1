package adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@ComponentScan(value = "controller")
public class WConfig {
	// @Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
		// 全局方法配置，只支持POST
		requestMappingHandlerAdapter.setSupportedMethods(HttpMethod.POST.name());
		return requestMappingHandlerAdapter;
	}
}
