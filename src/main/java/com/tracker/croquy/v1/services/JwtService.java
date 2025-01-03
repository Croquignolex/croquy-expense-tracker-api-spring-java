package com.tracker.croquy.v1.services;

import com.tracker.croquy.v1.services.interfaces.IJwtService;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
@Slf4j
public class JwtService implements IJwtService {
    @Value("${token.signing.key}")
    private String jwtSigningKey;
    @Value("${token.signing.duration}")
    private long jwtSigningDuration;
    @Value("${token.refresh.duration}")
    private long jwtRefreshDuration;

    @Override
    public String extractUsernameFormToken(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails, boolean refresh) {
        return tokenBuilder(new HashMap<>(), userDetails, refresh);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsernameFormToken(token);

        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);

        return claimsResolvers.apply(claims);
    }

    private String tokenBuilder(Map<String, Object> extraClaims, UserDetails userDetails, boolean refresh) {
        JwtBuilder builder = Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256);

        final Date expirationDate = new Date(System.currentTimeMillis() + ((refresh ? jwtRefreshDuration : jwtSigningDuration) * 1000));

        builder.setExpiration(expirationDate);

        return builder.compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}
