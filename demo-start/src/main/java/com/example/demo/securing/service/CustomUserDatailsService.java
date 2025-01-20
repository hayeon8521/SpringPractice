package com.example.demo.securing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securing.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service	// 이거 적어주면 websecurityconfig 에 빈등록 안해도 됨
@RequiredArgsConstructor
public class CustomUserDatailsService implements UserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 단건조회
		UserDTO userDTO = userMapper.getUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check");
		}

//		List<GrantedAuthority> role = new ArrayList<>();
//		userDTO.getRoles().forEach( r -> role.add(new SimpleGrantedAuthority(r.getRoleName()) ) );
//		return new User(userDTO.getLoginId(), userDTO.getPassword(), role);
		
		return new CustomerUser(userDTO);
	}

}
