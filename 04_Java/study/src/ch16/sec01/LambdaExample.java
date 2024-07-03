package ch16.sec01;

public class LambdaExample {
    //static은 같은 static만 부를 수 있음
    //action 내의 람다 함수가 실제로는 calculable 내에 있는 calculate 함수를 의미한다
    public static void main(String[] args) {
        action((x,y)->{
            int result = x+y;
            System.out.println("result: " + result);
        });

        action((x,y)->{
            int result = x-y;
            System.out.println("result: " + result);
        });
    }

    public static void action(Calculable calculable) {
        //데이터
        int x = 10;
        int y = 4;
        //데이터 처리
        //해당 부분에 제공되는 함수 역할이 람다식이다
        calculable.calculate(x, y);
    }
}
