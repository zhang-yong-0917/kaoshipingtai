package config;

//import com.easy.archiecture.interceptors.AuthInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")//扫描这个包路径下的类，符合扫描规则的类装配到spring容器中
//@EnableAspectJAutoProxy(proxyTargetClass = true) //使用CGlib的方式来实现动态代理
public class ServletConfig implements WebMvcConfigurer {
    //处理页面路径
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }


    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
        thymeleafViewResolver.setOrder(1);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setTemplateEngine(getSpringTemplateEngine());
        return thymeleafViewResolver;
    }
    @Bean
    public SpringTemplateEngine getSpringTemplateEngine(){
        SpringTemplateEngine springTemplateEngine=new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
        return springTemplateEngine;
    }
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        System.out.println("set spring resoucrce");
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }





//    @Bean
//    public InternalResourceViewResolver resourceViewResolver() {
//        //InternalResourceViewResolver会将视图名解析为JSP文件
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        //请求页面文件的前缀地址
//        internalResourceViewResolver.setPrefix("/");
//        //请求页面文件的后缀
//        internalResourceViewResolver.setSuffix(".html");
//        return internalResourceViewResolver;
//    }

    //开启spring DispatcherServlet 的支持
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    //让spring 知道当前项目中的除了页面之外的静态资源都放在哪个目录下。
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/js/").addResourceLocations("/js/**");
////        registry.addResourceHandler("/css/").addResourceLocations("/css/**");
//        registry.addResourceHandler("/static/*")
//                .addResourceLocations("classpath:/static/");
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LocaleChangeInterceptor())
//                .excludePathPatterns("classpath:/static/css/fonts/*.ttf")
//                .excludePathPatterns("classpath:/static/css/fonts/*.woff");
////        registry.addInterceptor(getAuthInterceptor()).addPathPatterns("/**");
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
//        converters.add(new MappingJackson2XmlHttpMessageConverter());
    }


//    @Bean
//    public HandlerInterceptor getAuthInterceptor() {
//        return new AuthInterceptor();
//    }
}
