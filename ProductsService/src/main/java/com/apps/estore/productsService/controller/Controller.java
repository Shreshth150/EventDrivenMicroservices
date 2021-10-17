package com.apps.estore.productsService.controller;

import com.apps.estore.productsService.commands.CreateProductCommand;
import com.apps.estore.productsService.rest.CreateProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class Controller {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public Controller(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel){

        CreateProductCommand createProductCommand = CreateProductCommand
                .builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();
        String returnValue;
        try {
             returnValue = commandGateway.sendAndWait(createProductCommand);
        }catch (Exception ex){
            returnValue = ex.getLocalizedMessage();
        }


        return returnValue;
    }

    @GetMapping
    public String handleRequest(){
        return "Hello";
    }
}
