package com.umurava.umapis.util;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.security}")
    private String SECRET_KEY;

    public String generateToken (String email) {
        return
    }
}
