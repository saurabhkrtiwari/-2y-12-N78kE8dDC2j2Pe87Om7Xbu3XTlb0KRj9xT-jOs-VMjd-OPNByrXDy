package com.Eretail.api.model.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.Products;
import com.Eretail.exceptions.ProductLineNotFoundException;

@Repository
@Transactional
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Products> getAllProducts() {
		@SuppressWarnings("unchecked")
		List<Products> productList = factory.openSession().createQuery("from Products p").list();
		// factory.getCurrentSession().close();
		return productList;
	}

	@Override
	public Products getProduct(String productCode) {
		Products productList = (Products) factory.openSession().get(Products.class, productCode);
		System.out.println("product list here-------------" + productList);
		//factory.getCurrentSession().close();
		return productList;
	}

	@Override
	public boolean addNewProduct(Products product) {
		try {
			System.out.println("In DAO");
			Productlines p = (Productlines)getSession().get(Productlines.class, "Classic_Cars");
			product.setProductlines(p);
			getSession().persist(product);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return true;
	}

	@Override
	public boolean updateProduct(String id, Products product) {
		Products p = getSession().get(Products.class, id);
		p.setProductName(product.getProductName());
		return true;
	}

	@Override
	public void deleteProduct(String productCode) {
		Products p = getSession().get(Products.class, productCode);
		getSession().delete(p);

	}

	@Override
	public void deleteProduct(Products products) {
		getSession().delete(products);;;
	}

}
