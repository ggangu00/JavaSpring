package com.example.demo.chef;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Restaurant {
	private final Chef chef;
}
