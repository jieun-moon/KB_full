package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //RootConfig 클래스를 뭐로 할건지 반환
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    //ServletConfig 클래스를 뭐로 할건지 반환
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    //스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, /: 모든 요청에 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //UTF-8 인코딩을 강제로 사용하도록 하는 필터 반환
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] {characterEncodingFilter};
    }
}
