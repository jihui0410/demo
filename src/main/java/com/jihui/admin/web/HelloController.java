package com.jihui.admin.web;

import com.jihui.admin.web.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class HelloController{

    @GetMapping("/postHello")
    public String Hello(){
        return "PostTestHello!!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDTO helloDTo(@RequestParam("name") String name, @RequestParam("amount") int amount) throws Exception{
        System.out.println("name::"+name);
        System.out.println("amount:::"+amount);
        return new HelloResponseDTO();
    }
}

