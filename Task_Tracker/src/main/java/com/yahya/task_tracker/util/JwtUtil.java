package com.yahya.task_tracker.util;
import java.security.Key;
import java.util.Base64;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "DGlayi3dq28BVjF2AA74fSYpz9U1Qo/47FKtoG4RvtSjuIuyqi4ce92ZxjjZsYdSfIMgV58f74o/dWB58XFMRQ==";
    private static final Key KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY));
    public static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}