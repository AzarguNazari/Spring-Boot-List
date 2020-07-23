package com.example.springbootmongo.business.contracts;

import com.example.springbootmongo.entities.Product;

import java.util.List;

public interface IProductService {
	
	List<Product> listAll();

    Product saveOrUpdate(Product product);

    void deleteModel(Product product);
}
