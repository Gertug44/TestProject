package org.example;

import javax.persistence.*;
import java.math.BigDecimal;

public class Person implements Comparable<Person>{

    private Integer id;
    private int age;
    private String firstName;
    private BigDecimal money;
    private String secondName;
    private Sex sex;
    private Long houseId;
    public long getId() {return id;}
    public int getAge() {return age;}
    public String getFirstName() {return firstName;}
    public BigDecimal getMoney() {return money;}
    public String getSecondName() {return secondName;}
    public boolean isSex() {return sex == Sex.MALE;}
    public Long getHouseId() {return houseId;}
    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.id);
    }

}
