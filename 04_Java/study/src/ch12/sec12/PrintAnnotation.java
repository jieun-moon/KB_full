package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//해당 어노테이션을 메소드에 적용하겠다(@Target: 적용 대상 설정)
@Target({ElementType.METHOD}) //적용 대상: METHOD
//해당 어노테이션을 런타임까지 유지하겠다(@Retention: 유지 정책 설정)
@Retention(RetentionPolicy.RUNTIME) //유지 정책: RUNTIME

public @interface PrintAnnotation {
    //value는 기본 속성
    String value() default "-"; //value 속성: 선의 종류
    int number() default 15; //number 속성: 출력 횟수
}
