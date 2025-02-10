package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Configuration
@EnableWebSecurity	// 스프링 부트에서 알아서 시큐리티 설정을 해줌
public class WebSecurityConfig {
	
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/main", "/fileDown", "/board/list", "/css/*", "/movie/*", "/**").permitAll()
				.requestMatchers("/board/*").hasAnyRole("USER","ADMIN")
				.requestMatchers("/emp/*", "/dept/*").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")	//로그인페이지 없으면 스프링에서 기본적으로 제공하는 페이지로 간다
				.usernameParameter("userid")
				.successHandler(authenticationSuccessHandler())
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			//.csrf(csrf -> csrf.disable())	// 기본적으로 사용으로 되어있음 이거 없애면 사용임
			;

		//http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html"));
		http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()) );
		return http.build();
	}
	
	//http.exceptionHandling(ex -> ex.accessDeniedHandler() );
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
}