package ru.gb.lesson_7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson_7.entities.Product;
import ru.gb.lesson_7.services.ProductService;

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
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "products";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/products";
    }

}
