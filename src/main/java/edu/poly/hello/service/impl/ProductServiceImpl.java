package edu.poly.hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.ProductDAO;
import edu.poly.hello.entiry.Product;
import edu.poly.hello.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO pdao;


	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}


	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}


	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return pdao.findByCategoryId(cid);
	}




}
