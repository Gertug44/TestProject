package org.example;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "person", schema = "public", catalog = "pflb_trainingcenter")
public class PersonEntity implements Comparable<PersonEntity>{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "money", nullable = false, precision = 2)
    private BigDecimal money;
    @Basic
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Basic
    @Column(name = "sex", nullable = false)
    private boolean sex;
    @Basic
    @Column(name = "house_id")
    private Long houseId;

    public long getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public BigDecimal getMoney() {return money;}
    public void setMoney(BigDecimal money) {this.money = money;}
    public String getSecondName() {return secondName;}
    public void setSecondName(String secondName) {this.secondName = secondName;}
    public boolean isSex() {return sex;}
    public void setSex(boolean sex) {this.sex = sex;}
    public Long getHouseId() {return houseId;}
    public void setHouseId(Long houseId) {this.houseId = houseId;}

    @Override
    public int compareTo(PersonEntity o) {
        return this.id.compareTo(o.id);
    }
    public boolean equal(Person person) {
        return this.id==person.getId() && this.age == person.getAge()
                && this.firstName.equals(person.getFirstName()) && this.secondName.equals(person.getSecondName())
                &&this.sex == person.isSex();
    }

    @Override
    public String toString(){
        return id.toString()+" "+age+" "+firstName+" "+secondName+" "+sex;
    }
}
