package com.jay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传功能
 */
@Slf4j
@Controller
public class FormController {

    @GetMapping("form_layouts.html")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @GetMapping("buttons.html")
    public String buttons(){
        return "form/buttons";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {

        log.info("上传信息：email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            // 保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\img\\"+originalFilename));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos){
                if(!photo.isEmpty()){
                    // 保存到文件服务器，OSS服务器
                    String originalFilename = photo.getOriginalFilename();
                    headerImg.transferTo(new File("F:\\img\\"+originalFilename));
                }
            }
        }

        return "index";
    }
}
