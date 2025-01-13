package cn.powernode;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替Spring框架的配置文件。
 * @author 动力节点
 * @version 1.0
 * @className Spring6Config
 * @since 1.0
 **/
@Configuration
@ComponentScan({"cn.powernode.dao", "cn.powernode.service"})
public class Spring6Config {
}
