package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");

        //문장 스트림을 단어 스트림으로 변환
        list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));

        System.out.println();
    }
}
