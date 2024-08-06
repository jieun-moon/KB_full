package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //업로드 처리가 되는 임시 파일
    final String LOCATION = "c:/upload";
    //MAX_FILE_SIZE: 한 개 파일의 최대 크기(한개)
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;
    //MAX_REQUEST_SIZE: 요청 하나 당 최대 크기. 파일 여러 개 업로드 가능(전체). 20MB
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;
    //FILE_SIZE_THRESHOLD: 파일 처리 시 HTTP로 파일이 들어오면 메모리에서 처리.
    //파일이 너무 크면, 메모리에서 처리하는게 부담스러움.
    //그래서, 이 사이즈가 넘어서는 파일은 메모리에서 처리가 아닌 파일에 저장했다 처리
    //5MB보다 작으면 메모리에서 처리해라
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    //스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, /: 모든 요청에 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] {characterEncodingFilter};
    }

    @Override
    //Dynamic: 여러 곳에서 쓰므로 import 할 때 주의. ServletRegistration 쓰는 Dynamic
    //나중에 project 템플릿에 반영시킬 사항
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION, //업로드 처리 디렉토리 경로
                MAX_FILE_SIZE, //업로드 가능한 파일 하나의 최대 크기
                MAX_REQUEST_SIZE, //업로드 가능한 전체 최대 크기(여러 파일 업로드하는 경우)
                FILE_SIZE_THRESHOLD); //메모리 파일의 최대 크기(이보다 작으면 실제 메모리에서만 작업)
        registration.setMultipartConfig(multipartConfig);
    }
}
