package com.example.springbootmongo.controller;

import com.example.springbootmongo.business.contracts.IProductService;
import com.example.springbootmongo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
	private IProductService productService;

  	@GetMapping
    public ResponseEntity<List<Product>>  getAll() {
        return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Product> saveOrUpdate(@RequestBody Product model) {
    	 return new ResponseEntity<>(productService.saveOrUpdate(model), HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity delete(@RequestBody Product model){
    	productService.deleteModel(model);
     	 return new ResponseEntity(HttpStatus.OK);
    }
    
}
