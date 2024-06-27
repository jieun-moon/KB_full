package L3;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x 값 입력: ");
        //질문: 여기서 nextInt를 하는 이유는....?
        //String의 값을 저장 저장해야하기 때문에
        int x = sc.nextInt();
        System.out.print("y 값 입력: ");
        int y = sc.nextInt();
        int result = x+y;
        System.out.print("x + y: " + result);
    }
}
