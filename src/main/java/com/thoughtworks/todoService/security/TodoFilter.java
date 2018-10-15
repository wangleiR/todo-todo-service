package com.thoughtworks.todoService.security;

import com.thoughtworks.todoService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Component
public class TodoFilter extends OncePerRequestFilter {

    @Autowired
    private UserClient userClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token  = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null){
            Map<String,Long> userInfo = userClient.getUser(token);
            Long userId = userInfo.get("userId");

            if (userId == null){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            User user = new User();
            user.setId(userId);
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            user,"",new ArrayList<>()
                    )
            );

        }
        filterChain.doFilter(request,response);

    }
}
