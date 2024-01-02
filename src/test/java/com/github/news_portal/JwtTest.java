package com.github.news_portal;

import com.github.news_portal.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
public class JwtTest {

    @Test
    public void testCreate(){
        Map<String, Object> perms = new HashMap<>();
        perms.put("perms", Arrays.asList("p1","p2"));
        perms.put("roles", Arrays.asList("r1","r2"));
        String jwt = JwtUtil.createJWT(perms);
        System.out.println(jwt);
    }

    @Test
    public void testParse(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJVc2VyIiwiQWRtaW5pc3RyYXRvciJdLCJpc3MiOiJuZXdzUG9ydGFsU2VydmVyIiwicGVybXMiOlsidXNlcnM6dmlldyIsImhvbWU6dmlldyIsInNldHRpbmdzOnZpZXciXSwiZXhwIjoxNzA0MTgyNTg4LCJ1dWlkIjoxLCJpYXQiOjE3MDQxNzg5ODgsInVzZXJuYW1lIjoiSm9obkRvZSJ9.UU0c9Qw1t_cnd4tZm4eERQ5VxdoqlOAkZZspmMS_0Gw";
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims);
        Object roles = claims.get("roles");
        System.out.println(roles);
    }
}
