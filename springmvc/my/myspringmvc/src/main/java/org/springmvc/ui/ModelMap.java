package org.springmvc.ui;

import java.util.LinkedHashMap;

/**
 * ClassName: ModelMap
 * Description:
 * Datetime: 2024/4/3 10:35
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class ModelMap extends LinkedHashMap<String,Object> {

    public ModelMap() {
    }

    /**
     * 向域当中绑定数据
     * @param name
     * @param value
     * @return
     */
    public ModelMap addAttribute(String name, Object value) {
        this.put(name, value);
        return this;
    }
}
