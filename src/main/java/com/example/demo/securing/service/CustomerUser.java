package com.example.demo.securing.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerUser implements UserDetails{
	
	UserDTO userDTO;
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		//return값 false 경우 로그인 불가 (계정에 따라 막기도)
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDTO.getRoles().stream()
					  .map(r-> new SimpleGrantedAuthority(r.getRoleName()))
					  .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return userDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return userDTO.getLoginId();
	}

}
