package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
//    @Select 어노테이션을 사용해서 SQL문을 직접 지정
//    MyBatis에 대한 구현제가 필요한데 MyBatis가 자동으로 생성해줌
    @Select("SELECT sysdate()")
//    인터페이스를 MyBatis에게 알려줘야함
//    데이터베이스에서 현재 시스템 날짜와 시간을 반환
    public String getTime();

//    이 타입에 대한 SQL문을 XML로 분리시키겠다
    public String getTime2();
}
