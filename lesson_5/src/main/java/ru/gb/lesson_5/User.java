package ru.gb.lesson_5;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user_id")
    List<ShopCart> shopCarts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShopCart> getShopCarts() {
        return shopCarts;
    }

    public void setShopCarts(List<ShopCart> shopCarts) {
        this.shopCarts = shopCarts;
    }

    @Override
    public String toString() {
        String allCarts = "";
        for (ShopCart shopCart : shopCarts) {
            allCarts += shopCart.getSize() + " ";
        }
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopCarts=" + allCarts +
                '}';
    }

}
