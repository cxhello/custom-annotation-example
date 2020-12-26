package com.cxhello.example.controller;

import com.cxhello.example.annotion.ExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxhello
 * @create 2020/12/26
 */
@RestController
public class IndexController {

    @ExecutionTime(methodDescription = "首页接口")
    @GetMapping("/index")
    public String index(String name) throws InterruptedException {
        Thread.sleep(1000);
        StringBuilder stringBuilder = new StringBuilder("Hello ,");
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

    @ExecutionTime(methodDescription = "登录接口")
    @GetMapping("/login")
    public String login(String userName, String password) throws InterruptedException {
        Thread.sleep(2000);
        String s = null;
        if ("cxhello".equals(userName) && "123456".equals(password)) {
            StringBuilder stringBuilder = new StringBuilder("Welcome ,");
            s = stringBuilder.append(userName).toString();
        } else {
            s = "please log in first";
        }
        return s;
    }

}
