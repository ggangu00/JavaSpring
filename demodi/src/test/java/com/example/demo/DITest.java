package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties.Restart;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.chef.Restaurant;
import com.example.demo.di.TV;

@SpringBootTest
public class DITest {
	
	//@Autowired TV tv;
	//@Autowired ApplicationContext context; //스프링 IoC 컨테이너 (빈을 담고있는)
	
	@Test
	@DisplayName("DI test")
	public void test1() {
		
//		//TV tv = context.getBean(TV.class);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();

	}
	
	
	@Autowired Restaurant restaurent;
	@Test
	public void test3() {
		restaurent.getChef().getName();
	}
}