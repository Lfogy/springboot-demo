package com.ligong.poi.controller;

import com.alibaba.fastjson.JSON;
import com.ligong.poi.domain.Product;
import com.ligong.poi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CmsBlogController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(){
        List<Product> products = productService.selectAll();
        System.out.println(products);
        return JSON.toJSONString(products);
    }

}
