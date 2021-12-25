package ru.gb.lesson_4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lesson_4.entities.Product;
import ru.gb.lesson_4.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(int id) {
        return productsRepository.getById(id);
    }

    public List<Product> getProductList() {
        return productsRepository.getProductList();
    }

    public void fillList() {
        productsRepository.fillList();
    }

    public void addProduct(Product product) {
        productsRepository.addProduct(product);
    }

}
