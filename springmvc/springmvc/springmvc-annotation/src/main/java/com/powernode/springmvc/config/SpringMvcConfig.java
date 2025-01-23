package com.powernode.springmvc.config;

import com.powernode.springmvc.interceptors.MyInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * ClassName: SpringMvcConfig
 * Description:
 * Datetime: 2024/3/29 19:07
 * Author: 老杜@动力节点
 * Version: 1.0
 */
// 以下相当于是 springmvc.xml 配置文件
@Configuration
// 组件扫描
@ComponentScan("com.powernode.springmvc.controller")
// 开启注解驱动
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    // 以下三个方法合并起来就是开启视图解析器
    @Bean
    public ThymeleafViewResolver getViewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(iTemplateResolver);
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver(ApplicationContext applicationContext) {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/thymeleaf/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);//开发时关闭缓存，改动即可生效
        return resolver;
    }

    // 开启静态资源处理，开启默认的Servlet处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("test");
    }

    /*
    <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <property name="exceptionMappings">
            <props>
                <prop key="java.lang.Exception">tip</prop>
            </props>
        </property>
        <property name="exceptionAttribute" value="yiChang"/>
    </bean>
     */

    // 配置异常处理器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        // 可以配置多个异常处理器，这是其中一个。
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        // 设置其中的 exceptionMappings 属性
        Properties prop = new Properties();
        prop.setProperty("java.lang.Exception", "tip");
        resolver.setExceptionMappings(prop);

        // 设置其中的 exceptionAttribute 属性
        resolver.setExceptionAttribute("e");

        // 将异常处理器添加到List集合中。
        resolvers.add(resolver);
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/test");
    }
}

/*
在springmvc.xml文件中都可以配置什么？
1.组件扫描
2.视图解析器
3.静态资源处理 default-servlet-handler
4.视图控制器 view-controller
5.开启注解驱动 <mvc:annotation-driven/>
6.异常处理器
7.拦截器
 */
