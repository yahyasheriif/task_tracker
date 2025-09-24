package com.yahya.task_tracker.config;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.yahya.task_tracker.util.JwtUtil;
import io.micrometer.common.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response, 
        @NonNull FilterChain filterChain)
            throws ServletException, IOException {
                String token = request.getHeader("Authorization");
                if (token != null && token.startsWith("Bearer ")) {
                    if(jwtUtil.validateToken(token.substring(7))){
                        UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(
                            jwtUtil.extractUsername(token.substring(7)), null, new ArrayList<>()
                            );
                            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
                            filterChain.doFilter(request, response);
                            System.out.println("Token validation: " + jwtUtil.validateToken(token.substring(7)));   
                            System.out.println("Extracted username: " + jwtUtil.extractUsername(token.substring(7)));
                            System.out.println("Authentication set: " + (SecurityContextHolder.getContext().getAuthentication() != null));
            }
            else{
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
            }
        }else{
            filterChain.doFilter(request, response);
        }
}}
