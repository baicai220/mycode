package org.springmvc.web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springmvc.web.constant.Const;
import org.springmvc.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * ClassName: DispatcherServlet
 * Description: 前端控制器
 * Datetime: 2024/4/3 9:48
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class DispatcherServlet extends HttpServlet {

    /**
     * 视图解析器
     */
    private ViewResolver viewResolver;

    /**
     * 处理器映射器
     */
    private HandlerMapping handlerMapping;

    /**
     * 处理器适配器
     */
    private HandlerAdapter handlerAdapter;

    @Override
    public void init() throws ServletException {
        // 找到springmvc.xml文件
        /**
         *         <init-param>
         *             <param-name>contextConfigLocation</param-name>
         *             <param-value>classpath:springmvc.xml</param-value>
         *         </init-param>
         */
        // 根据以上的配置找 springmvc.xml文件
        // 获取ServletConfig对象（Servlet配置信息对象，该对象由web容器自动创建，并且将其传递给init方法，我们在这里调用以下方法可以获取该对象）
        ServletConfig servletConfig = this.getServletConfig();
        String contextConfigLocation = servletConfig.getInitParameter(Const.CONTEXT_CONFIG_LOCATION);
        System.out.println("contextConfigLocation-->" + contextConfigLocation);
        String springMvcConfigPath = null;
        if(contextConfigLocation.trim().startsWith(Const.PREFIX_CLASSPATH)){
            // 条件成立，表示这个配置文件要从类的路径当中查找
            // 从类路径当中找springmvc.xml文件
            springMvcConfigPath = Thread.currentThread().getContextClassLoader().getResource(contextConfigLocation.substring(Const.PREFIX_CLASSPATH.length())).getPath();
            // 对路径中的特殊字符进行解码操作。让其正常显示。
            springMvcConfigPath = URLDecoder.decode(springMvcConfigPath, Charset.defaultCharset());
            System.out.println("Spring MVC配置文件的绝对路径：" + springMvcConfigPath);
        }

        // 初始化Spring Web容器
        WebApplicationContext webApplicationContext = new WebApplicationContext(this.getServletContext(), springMvcConfigPath);
        // webApplicationContext 代表的就是Spring Web容器，我们最好将其存储到 Servlet上下文中。以便后期的使用。
        this.getServletContext().setAttribute(Const.WEB_APPLICATION_CONTEXT, webApplicationContext);

        // 初始化处理器映射器
        this.handlerMapping = (HandlerMapping) webApplicationContext.getBean(Const.HANDLER_MAPPING);
        // 初始化处理器适配器
        this.handlerAdapter = (HandlerAdapter) webApplicationContext.getBean(Const.HANDLER_ADAPTER);
        // 初始化视图解析器
        this.viewResolver = (ViewResolver) webApplicationContext.getBean(Const.VIEW_RESOLVER);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    /**
     * DispatcherServlet前端控制器最核心的方法。
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.根据请求对象获取对应的处理器执行链对象
            HandlerExecutionChain mappedHandler = handlerMapping.getHandler(request);

            // 2.根据“处理器方法”获取对应的处理器适配器对象
            HandlerAdapter ha = this.handlerAdapter;

            // 3.执行拦截器中的preHandle方法
            if (!mappedHandler.applyPreHandle(request, response)) {
                return;
            }

            // 4.执行处理器方法，并返回ModelAndView
            ModelAndView mv = ha.handle(request, response, mappedHandler.getHandler());

            // 5.执行拦截器中的postHandle方法
            mappedHandler.applyPostHandle(request, response, mv);

            // 6.响应
            // 通过视图解析器进行解析，返回View对象
            View view = viewResolver.resolveViewName(mv.getView().toString(), Locale.CHINA);
            // 渲染
            view.render(mv.getModel(), request, response);

            // 7.执行拦截器中的afterCompletion方法
            mappedHandler.triggerAfterCompletion(request, response, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
