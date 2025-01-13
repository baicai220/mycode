package com.powernode.spring6.bean;

import org.springframework.stereotype.Service;

/**
 * @author 动力节点
 * @version 1.0
 * @className Order
 * @since 1.0
 **/
@Service // 如果你把整个value属性全部省略了，bean有没有默认的名称？有：类名首字母变小写就是bean的名字。
public class Order {
}

/*

以上的这个注解@Service就相当于以下的这个配置信息：
<bean id="order" class="com.powernode.spring6.bean.Order"></bean>

*/
