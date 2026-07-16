package com.workspace.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


//filter JWT Token
@Component
public class JwtFilter extends OncePerRequestFilter
{
	private static final Logger logger = 
			LoggerFactory.getLogger(JwtFilter.class);
	
    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil)
    {
        this.jwtUtil = jwtUtil;
    }
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException
    {
    	logger.info("JwtFilter Executed");
    	String authHeader =
    	        request.getHeader("Authorization");
    	
    	if(authHeader == null ||
    			   !authHeader.startsWith("Bearer "))
    			{
    			    filterChain.doFilter(request,response);
    			    return;
    			}
    	
    	String token =
    	        authHeader.substring(7);
    	
    	if(jwtUtil.validateToken(token))
    	{
    		logger.info("JWT is VALID");
    	    String username =
    	            jwtUtil.extractUsername(token);
		    String role = jwtUtil.extractRole(token);

    	    logger.info(token);
    	    logger.info("username:{}",username);
			logger.info("role:{}",role);
    	    
    	    GrantedAuthority authority =
    	            new SimpleGrantedAuthority(     //GrantedAuthority this is an interface so directly can be created object so spring SimpleGrantedAuthority
    	                    "ROLE_" + role);

    	    UsernamePasswordAuthenticationToken authentication =
    	            new UsernamePasswordAuthenticationToken(
    	                    username,
    	                    null,
    	                    List.of(authority));

    	    SecurityContextHolder
    	            .getContext()
    	            .setAuthentication(authentication);
    	}
    	else
    	{
    	    logger.info("JWT is INVALID");
    	}

    	filterChain.doFilter(request, response);

    }
}
