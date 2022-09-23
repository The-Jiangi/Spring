package org.jar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    /** ����ӳ�� */
    @RequestMapping("/")
    public String index() {
        // ������ͼ����
        return "index";
    }

    /** ����ӳ�� */
    @RequestMapping(value = "/target")
    public String toTarget() {
        return "target";
    }
}
