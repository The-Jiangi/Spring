package com.jay.controller;

import com.jay.bean.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 登录页面
     * */
    @GetMapping(value = {"/", "/login"})
    public String getIndex(){

        return "login";
    }

    @PostMapping("/login")
    public String setLogin(User user, HttpSession session, Model model){

        if (!StringUtils.isNullOrEmpty(user.getUsername()) && user.getPassword().equals("1111")){
            // 把登录成功的用户保存起来
            session.setAttribute("user",user);
            // 登录成功，重定向到 main接口（访问 main请求）；防止表单重复提交
            return "redirect:/index";
        }
        else {
            model.addAttribute("msg","账号密码错误");
            // 登录失败，返回登录页面
            return "login";
        }
    }

    @GetMapping("/index")
    public String getMain(HttpSession session, Model model){
        // 拦截器(过滤器)，判断登录的用户是否为空
        if (session.getAttribute("user") != null){
            return "index";
        }
        else {
            model.addAttribute("msg","请重新登录！");
            return "login";
        }

    }
}
