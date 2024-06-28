package L3;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        //scanner: 클래스. 콘솔에서 들어오는 키보드 I/O로 들어오는 입력 값을 받는 것
        Scanner sc = new Scanner(System.in);

        System.out.print("x 값 입력: ");
        //질문: 여기서 nextInt를 하는 이유는....?
        //String의 값을 저장 저장해야하기 때문에
        //nextInt: 다음에 scanner로 들어오는 것 중에서 int값만 가져온다
        //nextInt: 엔터를 포함하지 않음
        //nextLine: 개행을 포함함
        //sc로 호출되는 순간 받을 수 있음

        int x = Integer.parseInt(sc.nextLine());

//        String x = sc.nextline();
        System.out.print("y 값 입력: ");
        int y = sc.nextInt();
        int result = x+y;
        System.out.print("x + y: " + result);
    }
}
