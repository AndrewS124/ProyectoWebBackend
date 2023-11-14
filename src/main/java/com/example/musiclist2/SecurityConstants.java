package com.example.musiclist2;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class SecurityConstants {

    public static final long JWT_EXPIRATION_TIME = 7000000; // 1 day
    public static final byte[] SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

}
