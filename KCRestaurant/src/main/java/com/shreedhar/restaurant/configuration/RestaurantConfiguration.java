package com.shreedhar.restaurant.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.shreedhar.restaurant")
public class RestaurantConfiguration extends WebMvcConfigurerAdapter{
	
	  @Bean
	    public VelocityConfigurer velocityConfig() {
	        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
	        velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");
	        return velocityConfigurer;
	    }
	     
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        VelocityViewResolver viewResolver = new VelocityViewResolver();
	         
	        viewResolver.setViewClass(VelocityView.class);
	        viewResolver.setCache(true);
	        viewResolver.setPrefix("");
	        viewResolver.setSuffix(".html");
	        viewResolver.setExposeSpringMacroHelpers(true);
	 
	        registry.viewResolver(viewResolver);
	    }
	 
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
	    }
	    
	    @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	    }
	 

}
