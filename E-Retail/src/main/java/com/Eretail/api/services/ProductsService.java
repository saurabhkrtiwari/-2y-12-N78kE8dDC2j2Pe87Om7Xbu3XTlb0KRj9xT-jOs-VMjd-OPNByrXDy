package com.Eretail.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.Products;
import com.Eretail.api.model.DAO.ProductDAO;

@Service
public class ProductsService implements ProductsServiceInterface {

	@Autowired
	ProductDAO dao;

	@Override
	public List<Products> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public Products getProduct(String id) {
		
		return dao.getProduct(id);
	}

	

	@Override
	public boolean updateProduct(String id, Products t) {
		return dao.updateProduct(id, t);
		
	}

	@Override
	public void deleteProduct(String id) {
		dao.deleteProduct(id);
		
	}

	@Override
	public void deleteProduct(Products p) {
		dao.deleteProduct(p);
		
	}

	@Override
	public boolean addNewProduct(Products product) {
		// TODO Auto-generated method stub
		boolean flag = dao.addNewProduct(product);
		return flag;
	}
	
	
}
