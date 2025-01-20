package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LamdaTest {

	@Test
	public void sort() {
		List<SampleVO> list = Arrays.asList(new SampleVO("홍길동", 10),
										   	new SampleVO("홍길동2", 20),
										   	new SampleVO("홍길동3", 30),
										   	new SampleVO("홍길동4", 40));
		//Collections.sort(list, new SampleCompare());
		//익명클래스
		
		Collections.sort(list, new Comparator<SampleVO>() {

			@Override
			public int compare(SampleVO o1, SampleVO o2) {
				return o1.getName().compareTo(o2.getName());
		}});
		
		/* 람다식으로 표현
		Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
				return o1.getName().compareTo(o2.getName());
			});
		*/
		System.out.println(list);
		
	}
}

class SampleCompare implements Comparator<SampleVO>{

	@Override
	public int compare(SampleVO o1, SampleVO o2) {
		return o2.age - o1.age;
		//return o1.getName().compareTo(o2.getName());
	}
	
}