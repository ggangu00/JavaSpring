package com.example.demo.securing.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securing.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//단건조회
		UserDTO userDTO = userMapper.getUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check");
		}
		
		//상속하지 않고 자체적으로 리턴
		//List<GrantedAuthority> role = new ArrayList<>();
		//userDTO.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName()) ));
		//return new User(userDTO.getLoginId(), userDTO.getPassword(), role);
		
		//userDTO에서 상속하는 경우 리턴값
		//return userDTO;
		
		//CustomerUser에서 상속하는 경우 리턴값
		return new CustomerUser(userDTO);
		
	}

}
