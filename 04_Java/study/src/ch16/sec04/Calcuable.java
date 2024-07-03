package ch16.sec04;

@FunctionalInterface
public interface Calcuable {
    //추상 인터페이스에서는 함수가 무조건 1개 있어야 함
    double calc(double x, double y);
}
