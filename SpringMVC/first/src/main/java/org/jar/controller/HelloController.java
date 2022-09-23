package org.jar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    /** «Î«Û”≥…‰ */
    @RequestMapping("/")
    public String index() {
        // ∑µªÿ ”Õº√˚≥∆
        return "index";
    }

    /** «Î«Û”≥…‰ */
    @RequestMapping(value = "/target")
    public String toTarget() {
        return "target";
    }
}
