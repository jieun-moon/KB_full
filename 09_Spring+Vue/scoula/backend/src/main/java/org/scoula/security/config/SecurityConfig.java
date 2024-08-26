package org.scoula.security.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"}) //운영에 필요한 어노테이션
@ComponentScan(basePackages = {"org.scoula.security"}) //운영에 필요한 어노테이션
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter { //버전마다 살짝 다르지만 우리는 WebSecurityConfigurerAdapter 사용

    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;
//    JwtUsernamePasswordAuthenticationFilter: 생성자 주입 못함
//    SecurityConfig가 만들어지는 과정에서 등록이 되기 때문에 JwtUsernamePasswordAuthenticationFilter만 autowired해야힘.(final 키워드 붙이면 에러)

    //위의 @ComponentScan을 통해 생성자 주입
    private final UserDetailsService userDetailsService; //(제일 중요)
    private final AuthenticationErrorFilter authenticationErrorFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;


    @Bean //비밀번호 인코더 빈 등록
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } //PasswordEncode의 구현체
    //위의 두가지가 Authentication Manager 구성할 때 필요함

    //문자셋 필터(기존 문자셋 필터는 일반 필터에 있음. 보안필터 통과 안할때는 post 요청에 한글 처리)
//    보안 필터 통과할 때는 요청 파라미터 전부 해석해서 일반 필터의 문자셋 필터가 동작 안함. post 요청에 한글이 있으면 다 깨지게 됨
//    따라서, 보안필터 제일 앞에도 문자셋 필터 설정해야 함.
//    보안필터: 1. 문자셋 필터, 2. csrf 필터


    @Bean //AuthenticationManager 빈등록
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); //부모 클래스가 authenticationManager를 가지고 있음
//        부모가 authenticationManager를 리턴하고 걔를 Bean으로 등록한다는 뜻
    }

    //cross origin 접근 허용
//    다양한 도메인에 서버 요청 보낼 수 있음
//    기본적으로 요청을 보낸 사람만 가능하게 서버에 접근 가능하게 해주는데, 다른 사람도 접근할 수 있게 해주는 것
    @Bean
    public CorsFilter corsFilter() {
//        Cors 설정을 적용할 URL 소스 생성
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        Cors 설정을 위한 객체 생성
        CorsConfiguration config = new CorsConfiguration();
//        자격 증명(쿠키, 인증 헤더 등)을 포함한 요청을 허용하도록 설정
        config.setAllowCredentials(true);
//        모든 도메인에서 오는 요청 허용(*은 모두라는 의미)
        config.addAllowedOriginPattern("*"); //바로 밑에 있는 애들만
//        모든 헤더 허용
        config.addAllowedHeader("*");
//        모든 HTTP 메서드 허용(GET, POST, PUT, DELETE)
        config.addAllowedMethod("*");
//        설정된 cors 구성을 모든 경로에 적용("/**)에 적용(하위 경로 포함)
        source.registerCorsConfiguration("/**", config); //서브 경로까지 다 포함(root 밑에 붙었으면 모든 url에 대해 적용)
//        설정된 소스 기반으로 새로운 CorsFilter 반환
        return new CorsFilter(source);
    }

    //접근 제한 무시 경로 설정 - resource
//    특정 경로에 대한 보안 필터를 작용하지 않도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
//        해당 경로들은 보안 검사 무시
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
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



//    필터 구성하는 일
//    문자셋 필터를 맨 앞에 제시
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        한글 인코딩 필터 설정
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                //인증 에러 필터
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
                //Jwt 인증 필터, 기준 필터는 사용자 필터로 사용 못함
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                //로그인 인증 필터 (기준 필터: UsernamePasswordAuthenticationFilter. 이 필터 앞에 추가하라)
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //예외 처리 설정
        http
                .exceptionHandling()
//                인증 실패 시 처리할 객체
                .authenticationEntryPoint(authenticationEntryPoint)
//                접근 거부 시 처리할 객체
                .accessDeniedHandler(accessDeniedHandler);

        http
                .authorizeRequests()//경로별 접근 권한 설정
                .antMatchers(HttpMethod.OPTIONS).permitAll() //모든 OPTIONS 접근 허용
                .anyRequest().permitAll(); //나머지 요청들은 모든 접근 허용



        http.httpBasic().disable() //기본HTTP 인증 비활성화
                .csrf().disable() //CSRF 비활성화
                .formLogin().disable() //formLogin 비활성화 관련 필터 해제
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //세션 생성 모드 설정(stateless: 세션 사용 안하겠다)


    }

    @Override //Authentication Manager 구성
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

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
//        userDetailsService가 결정하는 것 : 유저 정보가 어디에 있는가 하는 것(DB, 다른 컴퓨터 등 다양함)
    }
}