package com.Eretail.api.model.DAO;

import java.util.List;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.Products;

public interface ProductDAO {
	
	List<Products> getAllProducts();
	Products getProduct(String productCode);
	boolean addNewProduct(Products product);
	boolean updateProduct(String id, Products product);
	void deleteProduct(String productCode);
	void deleteProduct(Products products);
	

}
