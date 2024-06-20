package ch07.sec10.exam02;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        //매개변수의 다형성
        //코드는 같지만 다르게 출력되므로 더 좋은 코드
        //위의 생성자는 중복되므로...
        animalSound(new Dog());
        animalSound(new Cat());
    }

    //파라미터로 객체를 주입받아서 다형성을 부여함
    //main 위에 선언돼도 상관없음
    public static void animalSound(Animal animal) {
        //(Animal animal)은 객체 주입한것
        animal.sound();
    }
}
