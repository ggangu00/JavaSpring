package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
	private Long id;
	private String title;
    private String author;
    private String content;
    
    //단건조회 entity => dto 변환
    public PostsResponseDto(Posts entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.content = entity.getContent();
    	this.author = entity.getAuthor();
    }
}
