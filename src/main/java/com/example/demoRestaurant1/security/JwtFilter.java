package com.example.demoRestaurant1.security;

import com.example.demoRestaurant1.ServiceImpl.JwtUtility;
import com.example.demoRestaurant1.ServiceImpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
        private JwtUtility jwtUtility;
        @Autowired
        private MyUserDetailsService myUserDetailsService;



    @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = null;
        String username = null;
       if (null != authorization && authorization.startsWith("Bearer")) {
           token = authorization.substring(7);
           username = jwtUtility.extractUsername(token);
        }
        else {
            throw new RuntimeException("Token missing");
       }
        if (null != username && SecurityContextHolder.getContext().getAuthentication() == null) {
           UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

            if (jwtUtility.validateToken(token, userDetails)) {
               UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                       new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
               usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }
            else{
                throw new RuntimeException("Token not valid");
           }
            filterChain.doFilter(request, response);
        }

    }

}
