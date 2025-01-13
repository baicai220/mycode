package com.powernode.spring6.bean;

import org.springframework.stereotype.Controller;

/**
 * @author 动力节点
 * @version 1.0
 * @className Vip
 * @since 1.0
 **/
@Controller("vipBean") // 如果属性名是value的话，这个属性名可以省略。
public class Vip {
}

/*
以上的这个注解@Controller("vipBean")就相当于以下的这个配置信息：
<bean id="vipBean" class="com.powernode.spring6.bean.Vip"></bean>
 */
