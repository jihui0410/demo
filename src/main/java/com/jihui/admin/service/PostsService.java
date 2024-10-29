package com.jihui.admin.service;

import com.jihui.admin.domain.posts.Posts;
import com.jihui.admin.domain.posts.PostsRepository;
import com.jihui.admin.web.dto.PostsListResponseDTO;
import com.jihui.admin.web.dto.PostsResponseDto;
import com.jihui.admin.web.dto.PostsSaveRequestDto;
import com.jihui.admin.web.dto.PostsUpdateReqeustDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public List<PostsListResponseDTO> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        System.out.println("service inin!!");
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public PostsResponseDto findById(Long id){
        System.out.println("findById service in");
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        System.out.println("findById service out");
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostsUpdateReqeustDto requestDto){
        System.out.println("update service in");
        System.out.println("update service id:"+id);
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        System.out.println("update service out");
        return id;
    }

    @Transactional
    public void delete(Long id){
        System.out.println("delete service in");
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        postsRepository.delete(posts);
        System.out.println("delete service out");
    }
}