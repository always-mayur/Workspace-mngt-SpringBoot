package com.workspace.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.workspace.dto.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil 
{

	@Value("${jwt.secret}")
	private String secretKey;
	
	@Value("${jwt.expiration}")
	private long expiration;
	
	//Generating JWT
	public String generateToken(UserDTO user)
	{
		Date now = new Date();
		Date expiry = new Date(now.getTime()+expiration);
		
		return Jwts.builder().subject(user.getUsername()).claim("role",user.getRole()).
				issuedAt(now).expiration(expiry).
				signWith(getSigningKey()).compact();
	}
	
    private SecretKey getSigningKey()
    {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    //JWT library  its first needs to parse the token.
    private Claims extractAllClaims(String token)  //reverse of generateToken
    {
    	return Jwts
    	        .parser()
    	        .verifyWith(getSigningKey())
    	        .build()
    	        .parseSignedClaims(token)
    	        .getPayload();
    }
    
    //extractUsername
    public String extractUsername(String token)
    {
    	return extractAllClaims(token).getSubject();
    }
    
    //We are NOT checking the signature ourselves.The JWT library already does that inside
    // parseSignedClaims(token) , if there are any differences in signature it throws error 
    public boolean validateToken(String token)
    {
        try
        {
            extractAllClaims(token);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public String extractRole(String token)
    {
        return extractAllClaims(token)
                .get("role", String.class);
    }
}
