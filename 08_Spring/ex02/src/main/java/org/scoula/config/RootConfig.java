package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration: 설정
@Configuration
@ComponentScan(basePackages = {"org.scoula"})
//@ComponentScan: 해당 패키지에서 @Component를 찾아서 등록해주겠다
//org.scoula 패키지로 시작하는 하위 패키지 포함
//이 경로 안에 Component 찾아서 자동 등록
//SpringContext 레벨에서 Bean 이름으로 식별되는 경우 Singleton 운영
//ComponentScan: 1개의 Context를 만들어냄
//1개의 Class가 여러 Context에 등록 될 수 있음
public class RootConfig {

}
