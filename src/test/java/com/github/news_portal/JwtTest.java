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
        String jwt = JwtUtil.createJWT(perms);
        System.out.println(jwt);
    }

    @Test
    public void testParse(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJuZXdzUG9ydGFsU2VydmVyIiwicGVybXMiOlsiaG9tZTp2aWV3Il0sImF2YXRhciI6ImphbmUuc21pdGhAZXhhbXBsZS5jb20iLCJleHAiOjE3MDQxOTEwNTIsInV1aWQiOjIsImlhdCI6MTcwNDE4NzQ1MiwiZW1haWwiOiJqYW5lLnNtaXRoQGV4YW1wbGUuY29tIiwidXNlcm5hbWUiOiJKYW5lU21pdGgifQ.u7z2op2foOo56ouG_rn8Tuf0yih_iHcKw1ZO-Mk2iwQ";
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims);
    }
}
