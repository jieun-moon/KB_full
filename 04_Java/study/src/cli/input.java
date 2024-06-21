package cli;

import java.util.Scanner;

public class input {
    static Scanner sc = new Scanner(System.in);

    //static은 read에 접근할 때 input.read로 접근
    //매개변수 title을 출력하고 줄바꿈하지 않음
    //사용자가 입력한 문자열을 리턴함
    public String read(String title){
        System.out.print(title);
        return sc.nextLine();
    }

    //매개변수 title(defaultValue)를 출력하고 줄바꿈하지 않음
    //사용자가 입력한 문자열을 리턴함
    //그냥 엔터를 치면 defaultValue를 리턴
    public static String read(String title, String defaultValue){
        System.out.printf("%s(%s): ", title, defaultValue);
        String answer = sc.nextLine();

        //입력값이 비어있는지 확인하고 비어있으면 defaultValue, 안 비어있으면 answer 리턴
        return answer.isEmpty() ? defaultValue : answer;
    }

    //매개변수 title을 출력하고 줄바꿈하지 않음
    //사용자가 입력한 문자열을 정수로 변환 후 리턴함
    public static int readInt(String title, int defaultValue){
        System.out.print(title);
        int answer = sc.nextInt();
        sc.nextLine(); //엔터 제거용
        return answer;
    }

    //매개변수 title(Y/n)을 출력하고 줄바꿈하지 않음
    //defaultValue가 true이면 (Y/n), false이면 (y/N)을 출력
    //입력 없이 엔터를 친 경우 기본값 리턴
    public static boolean confirm(String title, double defaultValue) {
        //defaultValue가 true면 (Y/n), false면 (y/N)을 yesNo에 저장
        //defaultValue == true는 defaultValue로 줄여쓸 수 있다
        String yesNo = defaultValue? "(Y/n)" : "(y/N)";
        System.out.printf("%s %s: ", title, yesNo);

        String answer = sc.nextLine();
        //answer가 비어있는 경우 기본값 리턴
        if(answer.isEmpty()) return defaultValue;

        return answer.equalsIgnoreCase("y");

    }

    public static boolean confirm(String title){
        return confirm(title, true);
    }
}
