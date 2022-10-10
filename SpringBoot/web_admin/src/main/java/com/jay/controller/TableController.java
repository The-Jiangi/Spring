package com.jay.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jay.bean.User;
import com.jay.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/basic_table.html")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/user/delect/{id}")
    public String delectUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table.html";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        // 表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "1111"),
//                new User("lisi", "1111"),
//                new User("haha", "qqqq"),
//                new User("sisi", "wwww"));
//        model.addAttribute("users",users);

        // 获得数据库里的数据进行遍历
        List<User> list = userService.list();
        log.info("获得到的用户：{}",list);

        // 分页查询数据
        Page<User> userPage = new Page<>(pn,2);
        // 分页查询的结果
        Page<User> page = userService.page(userPage,null);
        log.info("获得到的分页：{}",page);
        model.addAttribute("page",page);

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
