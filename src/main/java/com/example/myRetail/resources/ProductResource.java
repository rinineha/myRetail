package com.example.myRetail.resources;

import com.example.myRetail.models.Product;
import com.example.myRetail.services.ProductService;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductResource {

    @Inject
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getByProductId(@PathVariable("id") String id) throws Exception{
        Product result = new Product();
        if( !id.isEmpty()) {
            result = productService.findByProductId(id);
        }
        if( null != result.getId()){
            return new ResponseEntity<>( result , HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> postByProductId(@Valid @RequestBody Product product) throws Exception{
        return new ResponseEntity<>( product, HttpStatus.CREATED);

    }
}
