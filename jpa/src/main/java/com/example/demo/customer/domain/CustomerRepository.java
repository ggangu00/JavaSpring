package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("select c.name from Customer c where id = :id and phone = :phone order by name desc")
	public Optional<Customer> findById(@Param("id") Long id, @Param("phone") String phone);
	public List<Customer> findByNameLike(String name);
	
	//이름도 like or phone like
	public List<Customer> findByNameLikeOrPhoneLikeOrderByNameDesc(String name, String phone);
}
