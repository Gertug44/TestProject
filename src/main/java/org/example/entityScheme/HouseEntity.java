package org.example.entityScheme;
import javax.persistence.*;

@Entity
@Table(name = "house", schema = "public", catalog = "pflb_trainingcenter")
public
class HouseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "floor_count", nullable = false)
    private Integer floor_count;
    @Basic
    @Column(name = "price", nullable = false)
    private float price;

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}
    public Integer getFloor_count() {return floor_count;}
    public void setFloor_count(Integer floor_count) {this.floor_count = floor_count;}
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public boolean equal(HouseEntity house) {
        var equal = 0;
        equal += house.id.equals(this.id) ? 1: 0;
        equal += house.floor_count.equals(this.floor_count) ? 1: 0;
        equal += house.price == this.price ? 1: 0;
        return equal == 3;
    }
    public boolean equal(Integer id, Integer floor_count, float  price){
        return id.equals(this.id) &&  floor_count.equals(this.floor_count) && price==this.price;
    }
}
