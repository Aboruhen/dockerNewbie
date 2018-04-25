package com.docker.simple.controllers;

import com.docker.simple.domain.Product;
import com.docker.simple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        Iterable<Product> all = productRepository.findAll();
        Product product1 = new Product();
        product1.setName("test1");
        product1.setPrice(1);
        Product product2 = new Product();
        product2.setName("test2");
        product2.setPrice(2);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        all.forEach(products::add);
        model.addAttribute("products", products);
        System.out.println("Returning rpoducts:");
        return "products";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public String saveProduct(Product product){
        Product save = productRepository.save(product);
        return "redirect:/products";
    }

}
