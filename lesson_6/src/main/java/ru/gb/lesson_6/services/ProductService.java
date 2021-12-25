package ru.gb.lesson_6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lesson_6.entities.Product;
import ru.gb.lesson_6.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        return products;
    }

    public List<Product> getFirstFive() {
        List<Product> products = productsRepository.findAllByIdIsBetween(1, 5);
        return products;
    }


}
