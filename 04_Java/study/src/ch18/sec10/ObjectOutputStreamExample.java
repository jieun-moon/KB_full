package ch18.sec10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/temp/object.data"));

        Member m1 = new Member("fall", "단풍이");
        Product p1 = new Product("노트북", 1500000);
        int[] arr1 = {1, 2, 3};

        //직렬화
        oos.writeObject(m1);
        oos.writeObject(p1);
        oos.writeObject(arr1);

        oos.flush();
        oos.close();

        System.out.println(m1);
        System.out.println(p1);
        //arr1의 주소값이 아닌 실제 값이 출력되게 하려면 어떻게 해야 했나?
        System.out.println(arr1);

    }
}
