package com.exemplo.apiavaliacaolivros.config;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
@Configuration public class CorsConfig {
 @Bean WebMvcConfigurer cors(){return new WebMvcConfigurer(){
 @Override public void addCorsMappings(CorsRegistry registry){registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET","POST","PUT","DELETE","OPTIONS").allowedHeaders("*");}
 };}
}
