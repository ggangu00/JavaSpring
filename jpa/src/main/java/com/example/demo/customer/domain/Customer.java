package com.example.demo.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;

@Getter
@Entity
//@Table(name = "cust")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //해당 어노테이션 선언 시 sequence
	private Long id;
	
	//@Column(name = "username", length = 50, nullable = false)
	private String name;	

	//@Column(columnDefinition = "clob")
	private String phone;
	
//	@OneToOne //Join
//	@JoinColumn(name = "address_id")
//	Address address;
	
//	@OneToMany(mappedBy="address")
//	List<Address> address;
	
	@Transient
	private String addr;
	
	@Transient //해당 컬럼 제외
	private String grade;
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	public Customer() {}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	};
}
