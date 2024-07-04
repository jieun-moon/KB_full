//package ch18.sec10;
//
//import lombok.Data;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
////toString이용하라고 했는데 롬복 사용하면 안되나
//@Data
//
//public class ObjectInputStreamExample {
//    public static void main(String[] args) throws Exception {
//        //교안에서 FileOutputStream를 선언하고 왜 또 ObjectOutputStream을 선언하는지...?
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/temp/object.data"));
//
//        Member m2 = (Member) ois.readObject();
//        Product p2 = (Product) ois.readObject();
//        int[] arr2 = (int[]) ois.readObject();
//
//        ois.flush();
//        ois.close();
//
//        System.out.println(m2);
//        System.out.println(p2);
//        System.out.println(arr2);
//}
