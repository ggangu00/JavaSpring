package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsAPIController {
	
	private final PostsService postsService;
	
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto requestDto) {
		postsService.save(requestDto);
		return requestDto;
	}
	
	@PutMapping("/api/v1/posts/{id}")
	public PostsUpdateRequestDto update(
					   @PathVariable(name="id") Long id,
			 		   @RequestBody PostsUpdateRequestDto requestDto) {
		postsService.update(id, requestDto);
		return requestDto;
	}
	
	@DeleteMapping("/api/v1/posts/{id}")
	public Long delete(@PathVariable(name="id") Long id) {
		postsService.delete(id);
		return id;
	}
	
}
