package com.bjajmd.mall.admin.common.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 
 * 在spring boot2.x中已经无法再使用WebMvcConfigurationAdapter,官方声明已过时.
 * 可以继承WebMvcConfigurationSupport或者实现WebMvcConfigurer
 * 
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
    private MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		/*
		   InterceptorRegistration addInterceptor =registry.addInterceptor(myHandlerInterceptor); // 排除配置
		   
		   addInterceptor.excludePathPatterns("/login","/login/main","/logout", "/genCaptcha","/showBlog/**");
		   addInterceptor.excludePathPatterns("/static/**");//排除静态资源 
		   
		   // 拦截配置
		   addInterceptor.addPathPatterns("/**");
		
		 */
        
       
        
        registry.addInterceptor(new MyHandlerInterceptor())
        		.addPathPatterns("/**")
        		.excludePathPatterns("/login","/login/main","/logout","/genCaptcha","/static/**","/showBlog/**");

        
        registry.addInterceptor(new BlogHandlerInterceptor())
        		.addPathPatterns("/showBlog/**");

        
        
        
        
        
    }
    //访问静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//
    }
	
   
    
    
   

    
    
	
	
    

	
	
	
	
	
	
}
