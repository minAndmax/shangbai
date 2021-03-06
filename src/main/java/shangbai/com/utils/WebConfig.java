package shangbai.com.utils;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.jsp");
		super.addInterceptors(registry);
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /*
        * 说明：增加虚拟路径(在此处配置的虚拟路径，用springboot内置的tomcat时有效，
        * 用外部的tomcat也有效;所以用到外部的tomcat时不需在tomcat/config下的相应文件配置虚拟路径了,阿里云linux也没问题)
        */
		
        registry.addResourceHandler("/upload/image/**").addResourceLocations("file:D:/upload/image/");
        registry.addResourceHandler("/upload/vedio/**").addResourceLocations("file:D:/upload/vedio/");

        super.addResourceHandlers(registry);
    }
	
}
