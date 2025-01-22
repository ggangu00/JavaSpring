package com.example.demo.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//도메인 entity는 setter를 쓰지 않기 위해 Data 안씀
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String zipcode;
	private String address;
	private String detailAddress;
	
//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	Customer customer;
	
	
}