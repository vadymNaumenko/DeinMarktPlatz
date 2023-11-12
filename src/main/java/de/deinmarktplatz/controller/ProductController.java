package de.deinmarktplatz.controller;

import de.deinmarktplatz.entity.Product;
import de.deinmarktplatz.entity.User;
import de.deinmarktplatz.repository.ProductRepository;
import de.deinmarktplatz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private  UserRepository userRepository;



    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public List<Product> all() {
        var all = productRepository.findAll();
        System.out.println(all);
        return all;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/product/{id}")
    public Product all(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
