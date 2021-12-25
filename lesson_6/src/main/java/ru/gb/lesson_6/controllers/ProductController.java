package ru.gb.lesson_6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.lesson_6.entities.Product;
import ru.gb.lesson_6.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String productPage(Model model) {
        List<Product> allProducts = productService.getFirstFive();
        model.addAttribute("products", allProducts);
        return "products";

    }
}
