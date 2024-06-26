package ch11.sec03.exam02;

import java.lang.reflect.Array;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i <= array.length; i++) {
            try {
                //인덱스 0번과 3번의 경우 숫자이므로 올바르게 처리됨
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                //i=4가 들어올 경우 인덱스 초과로 해당 예외 발생
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (Exception e) {
                //Exception은 모든 예외의 부모 클래스로 위에서 해당하지 않은 예외들이 들어올 경우 처리해줌
                //if문에서의 else와 같은 역할
                System.out.println("실행에 문제가 있습니다.");
            }
        }
    }
}
