package com.example.demo.di;

import lombok.Data;

@Data
//@AllArgsConstructor //인수가 2개인 생성자
//@NoArgsConstructor //기본생성자 (final안됨)
//@Component
public class LgTV implements TV{

	//@Setter(onMethod_ = {@Autowired})
	final Speaker speaker;
	int price;
	
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}