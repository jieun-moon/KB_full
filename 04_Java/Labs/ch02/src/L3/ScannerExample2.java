package L3;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("입력 문자열: ");
            String line = sc.nextLine();
            //질문: 여기서 왜 equals 검사를 하는가...?
            //입력 값을 받아서 검사해야 나갈지를 판단하므로
            if(line.equals("q")){
              break;
            }
            System.out.println("출력 문자열: " + line);
            System.out.println();
        }
        System.out.println("종료");
    }
}
