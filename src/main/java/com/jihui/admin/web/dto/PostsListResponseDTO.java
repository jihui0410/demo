package com.jihui.admin.web.dto;

import com.jihui.admin.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime create_date;
    private LocalDateTime modified_date;

    public PostsListResponseDTO(Posts posts){
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
    }
}
