package ch04.sec02;

public class IfExample {
    public static void main(String[] args) {
        int score = 93;

        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        }
        //중괄호로 묶어주지 않는 경우 한줄까지만 if문 내에 있는 문장으로 인식
        if (score < 90)
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");

    }
}
