package com.dsr.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Below CORS was for Angular front end
@Configuration
@EnableWebMvc
public class WebMVCConfiguration implements WebMvcConfigurer{
	
	public void addCORSMappings(CorsRegistry registry) {
		
		registry.addMapping("/api").allowedOrigins("http://localhost:4200");
	}

	
}
