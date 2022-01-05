package ru.gb.lesson_8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lesson_8.entities.Product;
import ru.gb.lesson_8.repositories.ProductsRepository;
import ru.gb.lesson_8.utils.ProductsNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(int id) {
        Optional<Product> product = productsRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductsNotFoundException("Product with id = " + id + " not found");
        }
        return product.get();
    }

    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productsRepository.findAll();
        return products;
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public void delete(int id) {
        Optional<Product> product = productsRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductsNotFoundException("Product with id = " + id + " not found");
        }
        productsRepository.delete(product.get());
    }
}
