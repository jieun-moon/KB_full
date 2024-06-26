package ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for (int i = 0; i <= array.length; i++) {
            try{
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + array[i]);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch(NullPointerException | NumberFormatException e) {
                //2가지 중에 어떤 예외가 들어오더라도 동일하게 처리
                //i = 1일 경우 숫자가 아니므로 NumberFormatException 예외 발생
                //i = 2일 경우 null이므로 NullPointerException 예외 발생
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }
}
