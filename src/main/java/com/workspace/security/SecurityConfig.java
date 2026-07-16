package com.workspace.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.workspace.constants.URIConstants;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // same as other annotations but contains configurations (like bean only )
@EnableMethodSecurity //Spring, start checking security annotations placed on methods.
@EnableWebSecurity
public class SecurityConfig 
{
	private final JwtFilter jwtFilter;
	
	public SecurityConfig(JwtFilter jwtFilter)
	{
		this.jwtFilter = jwtFilter ;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(
	        HttpSecurity http)
	        throws Exception
	{
	    http.csrf(csrf -> csrf.disable());

	    http.sessionManagement(session ->
	        session.sessionCreationPolicy(
	            SessionCreationPolicy.STATELESS));

	    http.authorizeHttpRequests(auth ->
	    auth
        .requestMatchers(
            URIConstants.LOGIN,
            "/swagger-ui/**",
            "/v3/api-docs/**"
        )
	            .permitAll()
	            .anyRequest()
	            .authenticated()
	    );

	    http.addFilterBefore(
	            jwtFilter,
	            UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}
	
}
