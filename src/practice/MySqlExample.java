package practice;

public class MySqlExample {
    public static void main(String[] args) {
        MySql mySqlExample = new MySql();

        mySqlExample.powerOn();

        String result1 = mySqlExample.connect(데이터베이스, MySQL);
        System.out.println(result1);

        mySqlExample.powerOff();
    }
}
