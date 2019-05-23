package com.samarth.app.ws.shared;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.samarth.app.ws.security.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int ITERATIONS = 10000;
	private final int KEY_LENGTH = 256;
	
	public String generateUserId(int length)
	{
		return generateRandomStrength(length);
	}
	
	public String generateAddressId(int length)
	{
		return generateRandomStrength(length);
	}

	private String generateRandomStrength(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i=0;i<length;i++)
		{
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}

	public static boolean hasTokenExpired(String token) {
		boolean returnValue = false;

		try {
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.getTokenSecret()).parseClaimsJws(token)
					.getBody();

			Date tokenExpirationDate = claims.getExpiration();
			Date todayDate = new Date();

			returnValue = tokenExpirationDate.before(todayDate);
		} catch (ExpiredJwtException ex) {
			returnValue = true;
		}

		return returnValue;
	}

	public static String generateEmailVerificationToken(String publicUserId) {
		 
		String token = Jwts.builder()
                .setSubject(publicUserId)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
                .compact();
        return token;
	}

}
