package org.scoula.security.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //위의 @ComponentScan을 통해 생성자 주입
    private final UserDetailsService userDetailsService; //(제일 중요)

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //PasswordEncode의 구현체

    //문자셋 필터
    public CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//        UTF-8 인코딩 설정
        encodingFilter.setEncoding("UTF-8");
//        강제로 UTF-8 인코딩을 적용하도록 설정
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //경로별 접근 권한 설정
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");

        //addFilterBefore 메서드를 사용하여 CharacterEncodingFilter를 CsrfFilter 이전에 추가
//        이 설정은 모든 요청에 대해 UTF-8 인코딩이 적용 후에 CSRF 보호가 이루어지도록 함
//        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
//        super.configure(http); //부모껄 먼저 처리하고 불러야 해서 밑에 있어야 함

//        form 기반 로그인 활성화, 나머지 설정은 모두 디폴트값 사용
        http.formLogin()
                .loginPage("/security/login") //로그인 페이지 GET 요청시
                .loginProcessingUrl("/security/login") //로그인 페이지의 form에서 제출 시(action)
                .defaultSuccessUrl("/"); //로그인 성공 시 리다이렉트 페이지

        http.logout() //로그아웃 설정 시작
                .logoutUrl("/security/logout") //POST: 로그아웃 호출 url
                .invalidateHttpSession(true) //세션 invalidate. 세션 초기화
//                remember-me: 브라우저 종료 시 기억하게 하는 기능(따로 설정 필요)
                .deleteCookies("remember-me", "JSESSION-ID") //삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); //GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure.................................");

//        메모리 내에 인증 설정
//        ROLE_ADMIN
//        auth.inMemoryAuthentication()
//                .withUser("admin") //사용자 이름 설정
////                .password("{noop}1234") //사용자 비밀번호 설정(noop(no operation): 암호화 미적용)
//                .password("$2a$10$TjJLTJVhgtYvjGTK8N.VPuOYORQjvtF/XNASjzWOcP4r22dXLGUOS")
//                .roles("ADMIN","MEMBER"); //ROLE_ADMIN과 MEMBER 역할 모두 소유
//
//        ROLE_MEMBER
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$TjJLTJVhgtYvjGTK8N.VPuOYORQjvtF/XNASjzWOcP4r22dXLGUOS")
//                .roles("MEMBER"); //ROLE_MEMBER 역할만 부여
//        in Memory use 정보 주석처리 한 이유: UserDetailsService와 같이 사용 불가

//        메모리 정보 대신 UserDetailsService를 사용해서 인증 처리하도록 설정
        auth
                .userDetailsService(userDetailsService) //사용자 정보 로드
                .passwordEncoder(passwordEncoder()); //비밀번호 암호화
    }
}