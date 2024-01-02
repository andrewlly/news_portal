package com.github.news_portal.web.filter;

import com.github.news_portal.domain.ResponseResult;
import com.github.news_portal.domain.entity.User;
import com.github.news_portal.security.LoginUser;
import com.github.news_portal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if(token == null){
            doFilter(request,response,filterChain);
            return;
        }

        Claims claims = null;
        try {
            claims = JwtUtil.   parseJWT(token);
        } catch (SignatureException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("please re-login");
            return;
        }
        //todo: handle token issue
        Long id = claims.get("id",Long.class);
        String email = claims.get("email", String.class);
        String username = claims.get("username",String.class);
        String avatar = claims.get("avatar",String.class);
        List<String> perm = claims.get("perm", ArrayList.class);
        User user = new User();
        user.setUid(id);
        user.setEmail(email);
        user.setAvatarUrl(avatar);
        user.setUserName(username);
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user);
        loginUser.setPermission(perm);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        doFilter(request,response,filterChain);
    }
}
