package com.apps.estore.productsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Controller {

    @GetMapping
    public String handleRequest(){
        return "Hello";
    }
}
