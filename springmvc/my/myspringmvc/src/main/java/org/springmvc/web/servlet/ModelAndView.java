package org.springmvc.web.servlet;

import org.springmvc.ui.ModelMap;

/**
 * ClassName: ModelAndView
 * Description: 模型与视图对象。
 * Datetime: 2024/4/3 9:55
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class ModelAndView {
    private Object view;
    private ModelMap model;

    public ModelAndView() {
    }

    public ModelAndView(Object view, ModelMap model) {
        this.view = view;
        this.model = model;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public void setViewName(String viewName){
        setView(viewName);
    }

    public ModelMap getModel() {
        return model;
    }

    public void setModel(ModelMap model) {
        this.model = model;
    }
}
