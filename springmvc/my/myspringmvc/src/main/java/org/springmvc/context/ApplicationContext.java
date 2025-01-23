package org.springmvc.context;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springmvc.stereotype.Controller;
import org.springmvc.web.bind.annotation.RequestMapping;
import org.springmvc.web.constant.Const;
import org.springmvc.web.method.HandlerMethod;
import org.springmvc.web.servlet.HandlerAdapter;
import org.springmvc.web.servlet.HandlerInterceptor;
import org.springmvc.web.servlet.HandlerMapping;
import org.springmvc.web.servlet.mvc.RequestMappingInfo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ApplicationContext
 * Description: Spring的IoC容器，Spring上下文，适合于普通的java项目
 * Datetime: 2024/4/3 11:49
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class ApplicationContext {
    private Map<String, Object> beanMap = new HashMap<>();

    public ApplicationContext(String xmlPath){
        try {
            // 解析xml文件
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(xmlPath));
            // 组件扫描
            Element componentScanElement = (Element)document.selectSingleNode("/beans/component-scan");
            Map<RequestMappingInfo, HandlerMethod> map = componentScan(componentScanElement);

            // 创建视图解析器
            Element viewResolverElement = (Element)document.selectSingleNode("/beans/bean");
            createViewResolver(viewResolverElement);

            // 创建拦截器
            Element interceptorsElement = (Element)document.selectSingleNode("/beans/interceptors");
            createInterceptors(interceptorsElement);

            // 创建org.springmvc.web.servlet.mvc.method.annotation下的所有的HandlerMapping
            createHandlerMapping(Const.DEFAULT_PACKAGE, map);

            // 创建org.springmvc.web.servlet.mvc.method.annotation下的所有的HandlerAdapter
            createHandlerAdapter(Const.DEFAULT_PACKAGE);

            System.out.println("Spring IoC容器的当前状态：" + beanMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建HandlerAdapter
     * @param defaultPackage
     */
    private void createHandlerAdapter(String defaultPackage) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("defaultPackage = " + defaultPackage);
        String defaultPath = defaultPackage.replace(".", "/");
        System.out.println("defaultPath = " + defaultPath);
        String absolutePath = Thread.currentThread().getContextClassLoader().getResource(defaultPath).getPath();
        absolutePath = URLDecoder.decode(absolutePath, Charset.defaultCharset());
        System.out.println("absolutePath = " + absolutePath);
        File file = new File(absolutePath);
        File[] files = file.listFiles();
        for(File f : files){
            String classFileName = f.getName();
            System.out.println("classFileName = " + classFileName);
            String simpleClassName = classFileName.substring(0, classFileName.lastIndexOf("."));
            System.out.println("simpleClassName = " + simpleClassName);
            String className = defaultPackage + "." + simpleClassName;
            System.out.println("className = " + className);
            // 获取Class
            Class<?> clazz = Class.forName(className);
            // 只有实现了HandlerMapping接口的，再创建对象
            if(HandlerAdapter.class.isAssignableFrom(clazz)){
                Object bean = clazz.newInstance();
                beanMap.put(Const.HANDLER_ADAPTER, bean);
                return;
            }
        }
    }

    /**
     * 创建HandlerMapping
     * @param defaultPackage
     */
    private void createHandlerMapping(String defaultPackage, Map<RequestMappingInfo, HandlerMethod> map) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println("defaultPackage = " + defaultPackage);
        String defaultPath = defaultPackage.replace(".", "/");
        System.out.println("defaultPath = " + defaultPath);
        String absolutePath = Thread.currentThread().getContextClassLoader().getResource(defaultPath).getPath();
        absolutePath = URLDecoder.decode(absolutePath, Charset.defaultCharset());
        System.out.println("absolutePath = " + absolutePath);
        File file = new File(absolutePath);
        File[] files = file.listFiles();
        for(File f : files){
            String classFileName = f.getName();
            System.out.println("classFileName = " + classFileName);
            String simpleClassName = classFileName.substring(0, classFileName.lastIndexOf("."));
            System.out.println("simpleClassName = " + simpleClassName);
            String className = defaultPackage + "." + simpleClassName;
            System.out.println("className = " + className);
            // 获取Class
            Class<?> clazz = Class.forName(className);
            // 只有实现了HandlerMapping接口的，再创建对象
            if(HandlerMapping.class.isAssignableFrom(clazz)){
                // 第一次写的时候调用了无参数构造方法创建对象。
                //Object bean = clazz.newInstance();
                // 后期修改了一下，调用有参数的构造方法来创建处理器映射器对象
                Constructor<?> con = clazz.getDeclaredConstructor(Map.class);
                Object bean = con.newInstance(map);
                beanMap.put(Const.HANDLER_MAPPING, bean);
                return;
            }
        }
    }

    /**
     * 创建拦截器
     * @param interceptorsElement
     */
    private void createInterceptors(Element interceptorsElement) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 准备一个List集合，存储拦截器对象
        List<HandlerInterceptor> interceptors = new ArrayList<>();
        // 获取该标签下所有的bean标签
        List<Element> beans = interceptorsElement.elements("bean");
        // 遍历bean标签
        for(Element beanElement : beans){
            String className = beanElement.attributeValue(Const.BEAN_TAG_CLASS_ATTRIBUTE);
            // 通过反射机制创建对象
            Class<?> clazz = Class.forName(className);
            Object interceptor = clazz.newInstance();
            interceptors.add((HandlerInterceptor) interceptor);
        }
        // 存储到IoC容器中
        beanMap.put(Const.INTERCEPTORS, interceptors);
    }

    /**
     * 创建视图解析器
     * @param viewResolverElement
     */
    private void createViewResolver(Element viewResolverElement) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String className = viewResolverElement.attributeValue(Const.BEAN_TAG_CLASS_ATTRIBUTE);
        System.out.println("视图解析器名字：" + className);
        // 通过反射机制创建对象
        Class<?> clazz = Class.forName(className);
        // 视图解析器对象
        Object bean = clazz.newInstance();
        // 获取当前bean节点下子节点property
        List<Element> propertyElements = viewResolverElement.elements(Const.PROPERTY_TAG_NAME);
        for(Element propertyElement : propertyElements){
            // 属性名
            String fieldName = propertyElement.attributeValue(Const.PROPERTY_NAME);
            // 将属性名转换为set方法名
            String setMethodName = fieldNameToSetMethodName(fieldName);
            // 属性值
            String fieldValue = propertyElement.attributeValue(Const.PROPERTY_VALUE);
            System.out.println("属性名：" + fieldName);
            System.out.println("set方法名：" + setMethodName);
            System.out.println("属性值：" + fieldValue);
            // 通过方法名获取方法
            Method setMethod = clazz.getDeclaredMethod(setMethodName, String.class);
            // 通过反射机制调用方法
            setMethod.invoke(bean, fieldValue);
        }
        // 添加到IoC容器
        //beanMap.put(firstCharLowCase(clazz.getSimpleName()), bean);
        beanMap.put(Const.VIEW_RESOLVER, bean);
    }

    /**
     * 将属性名转换为set方法名
     * @param fieldName
     * @return
     */
    private String fieldNameToSetMethodName(String fieldName) {
        return "set" + firstCharUpperCase(fieldName);
    }

    /**
     * 将一个字符串的首字母变大写
     * @param fieldName
     * @return
     */
    private String firstCharUpperCase(String fieldName) {
        return (fieldName.charAt(0) + "").toUpperCase() + fieldName.substring(1);
    }

    /**
     * 组件扫描
     * @param componentScanElement
     */
    private Map<RequestMappingInfo, HandlerMethod> componentScan(Element componentScanElement) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 创建处理器映射器大Map
        Map<RequestMappingInfo, HandlerMethod> map = new HashMap<>();

        // 获取包名
        String basePackage = componentScanElement.attributeValue(Const.BASE_PACKAGE);
        System.out.println("组件扫描的包：" + basePackage);
        // 获取包的路径
        String basePath = basePackage.replace(".", "/");
        System.out.println("组件包对应的路径：" + basePath);
        // 获取绝对路径
        String absolutePath = Thread.currentThread().getContextClassLoader().getResource(basePath).getPath();
        absolutePath = URLDecoder.decode(absolutePath, Charset.defaultCharset());
        System.out.println("组件包对应的绝对路径：" + absolutePath);
        // 封装为File对象
        File file = new File(absolutePath);
        // 获取该目录下所有的子文件
        File[] files = file.listFiles();
        // 遍历数组
        for(File f : files){
            String classFileName = f.getName();
            System.out.println("class文件的名字：" + classFileName);
            if(classFileName.endsWith(Const.SUFFIX_CLASS)){
                String simpleClassName = classFileName.substring(0, classFileName.lastIndexOf("."));
                System.out.println("简单类名：" + simpleClassName);
                String className = basePackage + "." + simpleClassName;
                System.out.println("完整类名：" + className);
                // 如果类上有 @Controller 注解，则实例化Controller对象, 并且将其存储到IoC容器当中。
                Class<?> clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(Controller.class)){
                    // 创建了Controller对象
                    Object bean = clazz.newInstance();
                    // 将其存储到IoC容器中（map集合）
                    beanMap.put(firstCharLowCase(simpleClassName), bean);
                    // 创建这个bean中所有的HandlerMethod对象，将其放到map集合中。
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method : methods){
                        if(method.isAnnotationPresent(RequestMapping.class)){
                            // 获取方法上的注解
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            // 创建RequestMappingInfo对象(key)
                            RequestMappingInfo requestMappingInfo = new RequestMappingInfo();
                            requestMappingInfo.setRequestURI(requestMapping.value()[0]); // 请求路径
                            requestMappingInfo.setMethod(requestMapping.method().toString()); // 请求方式
                            // 创建HandlerMethod对象(value)
                            HandlerMethod handlerMethod = new HandlerMethod();
                            handlerMethod.setHandler(bean);
                            handlerMethod.setMethod(method);
                            // 放到map集合
                            map.put(requestMappingInfo, handlerMethod);
                        }
                    }
                }
            }
        }
        return map;
    }

    /**
     * 这个方法的作用是将一个字符串的首字母变成小写
     * @param simpleClassName
     * @return
     */
    private String firstCharLowCase(String simpleClassName) {
        return (simpleClassName.charAt(0) + "").toLowerCase() + simpleClassName.substring(1);
    }

    /**
     * 通过beanName获取对应的bean
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return beanMap.get(beanName);
    }
}
