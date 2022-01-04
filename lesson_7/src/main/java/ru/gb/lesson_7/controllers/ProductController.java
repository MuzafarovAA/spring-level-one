package ru.gb.lesson_7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson_7.entities.Product;
import ru.gb.lesson_7.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    public static final int PAGE_SIZE = 5;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String productPage(
            Model model,
            @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        Page<Product> productPage = productService.getAllProductsPages(currentPage - 1, PAGE_SIZE);
        List<Product> products = productPage.getContent();
        int totalPages = productPage.getTotalPages();
        model.addAttribute("products", products);
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPages", totalPages);
        return "products";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/products";
    }

}
