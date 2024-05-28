package edu.poly.hello.service;

import java.util.List;

import edu.poly.hello.entiry.Product;

public interface ProductService {
	List<Product>findAll();

	Product findById(Integer id);



	List<Product> findByCategoryId(String cid);


}
