package com.github.news_portal.util;

import com.github.news_portal.security.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class JwtUtil {
    //valid for one hour
    public static final Long JWT_TTL = 60 * 60 *1000L;
    public static final String JWT_KEY = "newsPortal";


    public static String createJWT(Map<String,Object> claim) {
        JwtBuilder builder = getJwtBuilder(claim, null);
        return builder.compact();
    }

    public static String createJWT(LoginUser loginUser){
        Map<String,Object> claim = new HashMap<>();
        claim.put("uuid",loginUser.getUser().getUid());
        claim.put("username",loginUser.getUser().getUserName());
        claim.put("perms",loginUser.getPermission());
        claim.put("email",loginUser.getUser().getEmail());
        claim.put("avatar",loginUser.getUser().getEmail());
        JwtBuilder builder = getJwtBuilder(claim,null);
        return builder.compact();
    }




    private static JwtBuilder getJwtBuilder(Map<String,Object> claim,Long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setClaims(claim)
                .setIssuer("newsPortalServer")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
    }



    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }


    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}

