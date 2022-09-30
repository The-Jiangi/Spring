package com.jay.controller;

import com.jay.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//
//

/**
 * @author Administrator
 * @RestController = @Controller + @ResponseBody
 */

@Slf4j  // Log日志功能
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {  // import 第8行
        log.info("请求进来了....");
        return "Hello, Spring Boot 2! 你好：" + name;
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {
        return "GET-张三";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser() {
        return "POST-张三";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {
        return "PUT-张三";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser() {
        return "DELETE-张三";
    }


}
