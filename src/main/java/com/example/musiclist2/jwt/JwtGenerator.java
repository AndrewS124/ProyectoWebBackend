<<<<<<< HEAD
/*
package com.example.musiclist2.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

public class JwtGenerator {

    private final String secret;

    public JwtGenerator(String secret) {
        this.secret = secret;
    }

    public String generateToken(String username, List<String> roles) {
        Date expirationDate = new Date(System.currentTimeMillis() + 3600 * 1000); // 1 hour
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
<<<<<<< HEAD
}*/
=======
/*
package com.example.musiclist2.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;

public class JwtGenerator {

    private final String secret;

    public JwtGenerator(String secret) {
        this.secret = secret;
    }

    public String generateToken(String username, List<String> roles) {
        Date expirationDate = new Date(System.currentTimeMillis() + 3600 * 1000); // 1 hour
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
<<<<<<< HEAD
}*/
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
