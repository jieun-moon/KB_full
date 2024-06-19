package ch06.sec10.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        //static 필드와 메소드는 클래스명으로 접근한다

//        Calculator calc = new Calculator();
//        calc.count++;
//        Calculator calc2 = new Calculator();
//        calc2.count++;
//        calc.a += 20;
//        //같은 클래스면 같은 값 공유
//        int res = calc.a + 10;
//        System.out.println(res);
//        System.out.println(calc2.a);

        double result1 = 10*10*Calculator.pi;
        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.minus(10, 5);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);
    }
}
