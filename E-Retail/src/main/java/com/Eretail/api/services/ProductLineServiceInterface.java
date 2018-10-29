package com.Eretail.api.services;

import java.util.List;

import com.Eretail.api.model.Productlines;

public interface ProductLineServiceInterface {

	List<Productlines> getAllProductLines();

	Productlines getProductLine(String id);

	boolean addNewProductLines(Productlines catagory);

	void updateProductLines(String id, Productlines t);

	void deleteProductLines(Productlines id);

}