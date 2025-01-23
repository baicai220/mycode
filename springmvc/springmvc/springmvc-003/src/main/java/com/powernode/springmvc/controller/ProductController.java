package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ProductController
 * Description:
 * Datetime: 2024/3/25 23:02
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    //@RequestMapping("/product/detail")
    @RequestMapping("/detail")
    public String productDetail(){
        return "product_detail";
    }

}
