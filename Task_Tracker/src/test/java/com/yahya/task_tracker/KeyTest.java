package com.yahya.task_tracker;

import java.security.Key;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class KeyTest {
    
    @Test
    public void testSecretKeyGeneration() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String encodedKey = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(encodedKey);
}}
