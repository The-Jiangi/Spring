package com.jay.controller;


import com.jay.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @PostMapping("/saveuser")
    public Person savePerson(Person person) {
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      // @RequestHeader 获取请求头
                                      @RequestHeader("User-Agent") String Agent,
                                      @RequestHeader Map<String, String> header,
                                      // @RequestParam  获取请求参数 ?age=18&inters=篮球&inters=game
                                      @RequestParam("age") String age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      // @CookieValue 获取cookie值
                                      @CookieValue("Admin-Expires-In") String admin,
                                      @CookieValue("Admin-Expires-In") Cookie admin_cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", name);
        map.put("pv", pv);
//        map.put("Agent",Agent);
//        map.put("header",header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("admin", admin);
        System.out.println(admin_cookie.getName() + "  ====>  " + admin_cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> PostMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
