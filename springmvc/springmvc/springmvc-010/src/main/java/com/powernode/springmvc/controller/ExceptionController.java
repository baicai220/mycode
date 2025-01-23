package com.powernode.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName: ExceptionController
 * Description:
 * Datetime: 2024/3/29 13:00
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String tip(Exception e, Model model){
        model.addAttribute("yiChang", e);
        return "tip";
    }

}
