package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:v.properties")
@ComponentScan("debug.debugValueAnnotation")
public class ConfigC {
}
