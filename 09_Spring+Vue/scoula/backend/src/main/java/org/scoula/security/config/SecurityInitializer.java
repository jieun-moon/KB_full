package org.scoula.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    //문자셋 필터
    private CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }


    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//        보안 필터 실행 전에 인코딩 필터와 멀티파트 필터가 실행된다
        insertFilters(servletContext, encodingFilter(), new MultipartFilter());
    }
}