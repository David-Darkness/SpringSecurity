/*
package org.juan.hello.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;


@Component
@Slf4j
public class JwtUtils {


    @Value("${jwt.secret.key}") //asignamos de aplications properties
    private String SecretKey; //nos va a ayudar a firmar nuestro permiso para acceder

    @Value("${jwt.time.expiration}")
    private String timeExpiration;


    //crear un token de acceso

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //validar el token de acceso
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            log.error("Token invalido, error:"+ e.getMessage());
            return false;
        }
        return true;
    }

    //Obtener el username del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    //obtener un solo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }


    //obtener todos los claims(informacion) del token
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    //Obtener firma del token
    public Key getSignatureKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
*/