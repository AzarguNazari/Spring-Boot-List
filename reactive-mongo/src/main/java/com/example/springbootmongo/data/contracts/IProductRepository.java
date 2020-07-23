package com.example.springbootmongo.data.contracts;

import com.example.springbootmongo.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository  extends MongoRepository<Product, String> {

}
