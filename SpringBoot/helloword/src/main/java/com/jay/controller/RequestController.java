package com.jay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        return "forward:/success";  // 转发到 /success请求
    }

    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,    // 在跳转时，会将 map和 model里的数据放到 request中
                            HttpServletRequest request,
                            HttpServletResponse response){

        map.put("params_map","hello_map");
        model.addAttribute("params_model","hello_model");
        request.setAttribute("params_request","hello_request");

        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute(value = "msg", required = false) String msg, // required表示不是必填项
                                      HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Object params_map = request.getAttribute("params_map");
        Object params_model = request.getAttribute("params_model");
        Object params_request = request.getAttribute("params_request");

        Map<String,Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("msg1", msg1);
        map.put("params_map",params_map);
        map.put("params_model",params_model);
        map.put("params_request",params_request);

        return map;
    }
}
