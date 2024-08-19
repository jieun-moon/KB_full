package org.scoula.security.config;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //문자셋 필터
    public CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF 8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    //제일 중요한 설정이 아래에서 일어남
    //앞에서 설정한 인코딩 필터를 위치 시킴
    //두번째 매개변수 필터 앞에 추가하라는 뜻
    //CsrfFilter: 보안 필터에서 제일 먼저 동작
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        //경로별 접근 권한 설정
        //모두 허용: /security/all
//        특정 역할에게만 허용: /security/admin, /security/member
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

        http.formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure .......................................");

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN", "MEMBER"); //ROLE_ADMIN
        auth.inMemoryAuthentication()
                .withUser("member")
                .password("{noop}1234")
                .roles("MEMBER"); //ROLE_MEMBER
    }
}
