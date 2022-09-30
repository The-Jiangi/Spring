package com.jay.controller;

import com.jay.bean.Person;
import com.jay.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseController {

    @ResponseBody
    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(10);
        person.setBirth(new Date());
        person.setUserName("张三");
        person.setPet(new Pet("cat", 5));
        return person;
    }
}
