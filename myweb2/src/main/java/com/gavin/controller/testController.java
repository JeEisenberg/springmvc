package com.gavin.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class testController {
    @GetMapping(value = "/toInfo.do/{id}")
    public String toGET(@PathVariable("id") Integer id){
        System.out.println("get"+id);
        return "GetSuccess";
    }
    @PostMapping("/toInfo.do/{id}")
    public String toPost(@PathVariable("id") Integer id){
        System.out.println("post"+id);
        return "PostSuccess";
    }
    @PutMapping("/toInfo.do/{id}")
    public String toPut(@PathVariable("id") Integer id){
        System.out.println("put"+id);
        return "PutSuccess";
    }
    @DeleteMapping("/toInfo.do/{id}")
    public String toDel(@PathVariable("id") Integer id){
        System.out.println("del"+id);
        return "DelSuccess";
    }
}
