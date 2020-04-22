package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {

        return "Hello!"+girlProperties.getCupSize();
    }
    
}
