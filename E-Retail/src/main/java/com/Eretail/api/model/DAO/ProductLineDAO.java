package com.Eretail.api.model.DAO;

import java.util.List;

import com.Eretail.api.model.Productlines;

public interface ProductLineDAO {
	List<Productlines> getAllProductLines();

	Productlines getProductLine(String id);

	boolean addNewProductLines(Productlines catagory);

	void updateProductLines(String id, Productlines t);

	void deleteProductLines(String id);

	void deleteProductLines(Productlines p);
}
