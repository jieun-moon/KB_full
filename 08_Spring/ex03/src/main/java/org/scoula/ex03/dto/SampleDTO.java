package org.scoula.ex03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor //추가하면, 기본생성자 없어지게 됨
public class SampleDTO {
    private String name;
    private int age;

    //기본 생성자 중요
    //getter/setter 중요
}
