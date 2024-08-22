package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
//이미 SecurityConfig에서 org.scoula.security 스캔하고 있기 때문에 scan할 필요 없음
public class JwtProcessor {
//    토큰 유효 기간을 10분으로 설정
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 10; //5분

//    비밀 키 설정 -  개발시에는 서버 재기동하는 경우가 많으므로 임의의 문자열
    //개발 시 사용
    private String secretKey = "asld'jf'lksdfklsdmfklsdmfoisfa;a'spondfskjsnkwekhrldfaqpweoz ";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

//    비밀 키 설정 - 매번 변경되므로 운영시에만 사용
//    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); -- 운영시 사용

    //JWT 토큰 생성 메서드
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject) //주로 사용자 식별용
                .setIssuedAt(new Date()) //JWT 발급 시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND)) //JWT 만료 시간
                .signWith(key) //JWT 서명을 위한 키 설정
                .compact(); //JWT 문자열 생성
    }

    //JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생
    //예외 ExpiredJWTException, UnsupportedJwtException, MalformedJwtException, SignatureException,
//    IllegalArgumentException => RuntimeException
//    401에러(사용자가 로그아웃 됨을 알 수 있음)
//    JWT 토큰에서 사용자 이름 추출
//    유효하지 않은 토큰일 경우 예외 발생
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) //서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token)  //토큰 파싱. Jws는 서명이 있는 Jwt로 파싱. Jws는 서명이 있음(보안이 강화됨)/Jwt는 서명이 없는 파싱
                .getBody() //파싱한 토큰 가져옴
                .getSubject(); //Subject(사용자 이름) 반환
    }

    //JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생
//    예외처리는 json 문자열로 내보내야 함
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key) //서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token); //토큰 파싱 및 서명 검증
        return true; //유효한 토큰일 경우 true 반환
    }
}
