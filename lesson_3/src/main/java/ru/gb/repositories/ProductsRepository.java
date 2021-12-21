package ru.gb.repositories;

import org.springframework.stereotype.Component;
import ru.gb.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {

    private List<Product> productList = new ArrayList<>();

    public void fillList() {
        productList.add(new Product(0, "pr0", "100"));
        productList.add(new Product(1, "pr1", "200"));
        productList.add(new Product(2, "pr2", "300"));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getById(int id) {
        return productList.get(id);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

}
