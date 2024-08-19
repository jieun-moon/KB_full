package org.scoula.security.config;


import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

        //addFilterBefore 메서드를 사용하여 CharacterEncodingFilter를 CsrfFilter 이전에 추가
//        이 설정은 모든 요청에 대해 UTF-8 인코딩이 적용 후에 CSRF 보호가 이루어지도록 함
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
        super.configure(http); //부모껄 먼저 처리하고 불러야 해서 밑에 있어야 함

//        form 기반 로그인 활성화, 나머지 설정은 모두 디폴트값 사용
        http.formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/");

        http.logout() //로그아웃 설정 시작
                .logoutUrl("/security/logout") //POST: 로그아웃 호출 url
                .invalidateHttpSession(true) //세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") //삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); //GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure.................................");

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN","MEMBER"); //ROLE_ADMIN

        auth.inMemoryAuthentication()
                .withUser("member")
                .password("{noop}member")
                .roles("MEMBER"); //ROLE_MEMBER
    }
}