package practice;

import java.sql.SQLOutput;

public class trapezoid {
    public static void main(String[] args) {
        double x = 5;
        double y = 10;
        double h = 7;
        double span=(x+y)*h/2;

//        System.out.println("사다리꼴의 넓이: " + span);
        System.out.printf("사다리꼴의 넓이: %.2f\n", span);
    }
}
