package com.gavin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping("/fileUpload.do")
    @ResponseBody
    public String upDataPic(MultipartFile headerPic) throws IOException {//用MultipartFile接收数据
//        指定文件存储目录
//File dir=new File("C:"+File.separator+"imgs");
File dir=new File("D:\\Program Data\\idea2019Data\\SompleDemo\\myweb2\\target\\myweb2-1.0-SNAPSHOT\\static\\img");

//获取文件名
        String originalFilename = headerPic.getOriginalFilename();
//        文件存储位置
        File file=new File(dir,originalFilename);
//        文件保存
        headerPic.transferTo(file);
        return  "success";
    }
}
