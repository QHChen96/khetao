package com.khetao.luma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-14
 */
@RestController
public class HelloController {

    @PostMapping("/sayHello")
    public String sayHello(HttpServletRequest request) {
        request.getSession().setAttribute("name", "chenqinhao");
        return "OK";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return request.getSession().getAttribute("name").toString();
    }
}
