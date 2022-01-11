package ru.gb.lesson_8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson_8.entities.Product;
import ru.gb.lesson_8.services.ProductsService;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = productsService.getProductById(id);
        return product;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        List<Product> products = productsService.getAllProducts();
        return products;
    }

    @PostMapping
    public Product addProduct (@RequestBody Product product) {
        product.setId(0);
        return productsService.saveOrUpdate(product);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        return productsService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable int id) {
        productsService.delete(id);
        return HttpStatus.OK.value();
    }

}