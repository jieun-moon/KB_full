package practice;

public class MySql {
    void powerOn(){
        System.out.println("MySQL에 연결합니다.");
    }

    void powerOff(){
        System.out.println("MySQL을 닫습니다.");
    }

    String connect(String host, String pass){
        String result = host + pass;
        return result;
    }
}
