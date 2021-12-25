package ru.gb.lesson_5;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopcarts")
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private String size;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToMany
    @JoinTable(
            name = "products_shopcarts",
            joinColumns = @JoinColumn(name = "shopcarts_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String allProducts = "";
        for (Product product : products) {
            allProducts += product.getTitle() + " ";
        }
        return "ShopCart{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", user name=" + user_id.getName() +
                ", products=" + allProducts +
                '}';
    }



}
