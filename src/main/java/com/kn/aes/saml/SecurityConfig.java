package com.kn.aes.saml;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/saml2/**").permitAll()
                .anyRequest().authenticated()
            )
            .saml2Login()
            .and()
            .saml2Metadata();
        return http.build();
    }
    */
    
	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/","/saml2/**", "/actuator/health", "/error").permitAll()
	                .anyRequest().authenticated()
	            )
	            .saml2Login(Customizer.withDefaults())
	            .saml2Metadata(withDefaults())
	            .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
	        return http.build();
	    }
}