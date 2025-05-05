package com.ecommerce.ecommerce_api_gateway.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private final String SECRET = "5VMSl8KZWmsPKkoMrky3UgoKNLKPPctUMm3tzr9aXw3h1D0HK2WJgy8EtoCbshREP+l0a4OCRat7xrMU20aJ+2jsQojn/FRTYD9cgiGUvHQyPqVG/pKivcLv0rWF4Z3tyAguBREv9QslplYDrGR2U+uznH3oLvnDgKGOraOGrw7XZ5w6/awGBgYOvZR4VwPDEpW7jk/js1Vbj62YvVuGGM4H3E6e8ujzN98lHP43LZED71NJlbi+xyENICMftchhcCiH2KWa3yV0hswVghMrtdo0eVOK9dpNIzaBWXNGzsf/ZT7qixBQMp0Qzypsd7CDtBv6utOd/jBmHisFiJZ+3txgCPe5lHmV3f+uZflgJXg=";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }



    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
