package com.jihui.admin.web;

import com.jihui.admin.service.PostsService;
import com.jihui.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        System.out.println("mustache index(메인) in!");
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        System.out.println("mustache save(등록) in!");
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        System.out.println("mustach update in");
        System.out.println("mustach update getId:"+id);
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        System.out.println("mustach update out");
        return "posts-update";
    }

}
