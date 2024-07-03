package ch17.sec04.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
//Getter, Setter, toString을 다 합친 것이 Data

public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;
}
