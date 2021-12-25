package ru.gb.lesson_4.entities;

public class Product {
    private int id;
    private String title;
    private String cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Product(int id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }


}
