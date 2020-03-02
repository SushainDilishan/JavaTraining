package com.sushain.assigments;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sushi").password(passwordEncoder.encode("sushi123")).roles("USER","ADMIN","MANAGER")
		.authorities("CAN_READ","CAN_WRITE","CAN_UPDATE").and().
		withUser("devi").password(passwordEncoder.encode("devi123")).roles("USER").authorities("CAN_READ","CAN_WRITE");	
	}
}
