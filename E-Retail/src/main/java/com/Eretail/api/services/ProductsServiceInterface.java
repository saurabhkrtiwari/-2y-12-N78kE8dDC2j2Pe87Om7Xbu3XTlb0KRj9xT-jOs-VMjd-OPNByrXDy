package com.Eretail.api.services;

import java.util.List;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.Products;

public interface ProductsServiceInterface {
	
	List<Products> getAllProduct();

	Products getProduct(String id);

	boolean addNewProduct(Products product);

	boolean updateProduct(String id, Products t);

	void deleteProduct(String id);

	void deleteProduct(Products p);

}
