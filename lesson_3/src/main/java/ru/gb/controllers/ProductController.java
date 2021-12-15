package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Product;
import ru.gb.services.ProductsService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService (ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/showAll")
    public String productList(Model model) {
        List<Product> productsList = productsService.getProductList();
        model.addAttribute("productsList", productsList);
        return "products";
    }

    @RequestMapping(value = "/showProductById", method = RequestMethod.GET)
    public String showProductById(Model model, @RequestParam int id) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/showProductById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("id") int id){
        Product product = productsService.getProductById(id);
        return product;
    }

    @RequestMapping(value = "addProduct")
    public String showProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsService.addProduct(product);
        return "product-success";
    }

    @RequestMapping("/autoFill") // возможность автозаполнения из подготовленного списка
    @ResponseBody
    public String autoFill() {
        List<Product> productsList = productsService.getProductList();
        if (productsList.isEmpty()) {
            productsService.fillList();
        }
        return "OK";
    }

}