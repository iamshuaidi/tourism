package com.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UpLoadController {

    @RequestMapping("uploadImage")
    public String uploadImage(){
            return "static/image/111.jpg";
    }


}
