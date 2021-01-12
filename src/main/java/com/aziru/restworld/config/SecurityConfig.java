package com.aziru.restworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// Memory authentication

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()
//	.withUser("admin").password(encoder().encode("1234567890*")).roles("ADMIN").and()
//	.withUser("user").password(encoder().encode("1234567890")).roles("USER");
//    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().antMatchers("/users/**").hasRole("ADMIN").antMatchers("/roles/**").permitAll().anyRequest().authenticated()
		.and().httpBasic();
    }

    @Bean
    public PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
    }
}
