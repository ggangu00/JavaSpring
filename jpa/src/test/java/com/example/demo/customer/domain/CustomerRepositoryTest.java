package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Test
	@DisplayName("고객등록")
	public void insert() {
		//give
		Customer customer = new Customer("홍길동", "010-5689-7704");
		
		//when
		customerRepository.save(customer);
		addressRepository.save(Address.builder()
									  .address("123")
									  //.customer(customer)
									  .build());
		System.out.println("id : " + customer.getId());
		
		//then
		//단건조회결과와 비교
		Optional<Customer> result = customerRepository.findById(1L);
		Optional<Address> address = addressRepository.findById(1l);
		System.out.println("address : " + address);
		assertThat(result.get().getName()).isEqualTo("홍길동");
	}
	
	//@Test
	@DisplayName("고객수정")
	public void update() {
		//give
		Customer customer = new Customer("홍길동", "010-1234-5678");
		customerRepository.save(customer);
		
		//when
		Optional<Customer> result = customerRepository.findById(1L);
		result.get().setPhone("010-1234-1234");
		customerRepository.save(result.get());
		
		//then
		//단건조회결과와 비교		
		//assertThat(result.get().getName()).isEqualTo("홍길동");
	}
	
	//@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%im%";
		String phone = "%010%";
		//List<Customer> list = customerRepository.findByNameLike(name);
		List<Customer> list = customerRepository.findByNameLikeOrPhoneLikeOrderByNameDesc(name,  phone);
		
		System.out.println(list);
	}
	
	
//	@Test
	@DisplayName("이름단건검색")
	public void findById() {
		Long id = 1l;
		String phone = "010";
		Optional<Customer> customer = customerRepository.findById(id, phone);
		
		System.out.println(customer.get());
	}
}