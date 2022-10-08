package com.jay.controller;

import com.jay.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table.html")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(Model model){
        // 表格内容的遍历
        List<User> users = Arrays.asList(new User("zhangsan", "1111"),
                new User("lisi", "1111"),
                new User("haha", "qqqq"),
                new User("sisi", "wwww"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table.html")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
