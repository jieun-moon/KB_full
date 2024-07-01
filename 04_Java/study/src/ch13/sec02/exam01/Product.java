package ch13.sec02.exam01;

//제네릭 타입
//타입 파라미터로 K와 M을 사용함
public class Product<K, M>{ //타입 파라미터로 K와 M 정의
    //타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M model;

    //타입 파라미터를 리턴 타입과 매개 변수 타입으로 사용
    //단축키: Alt+Ins >  generate
    public K getKind() { return this.kind; }
    public M getModel() { return this.model; }
    public void setKind(K kind) { this.kind = kind; }
    public void setModel(M model) { this.model = model; }
}
