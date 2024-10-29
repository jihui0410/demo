package com.jihui.admin.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateReqeustDto {
    private String title;
    private String content;

    public PostsUpdateReqeustDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
