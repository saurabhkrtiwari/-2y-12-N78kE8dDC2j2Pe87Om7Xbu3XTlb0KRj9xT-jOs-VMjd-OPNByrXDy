package com.Eretail.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.Products;
import com.Eretail.api.services.ProductsServiceInterface;

@RestController
public class ProductController {

@Autowired
ProductsServiceInterface service;

@RequestMapping("/products")
@ResponseBody
public List<Products> getAllProducts()
{
	System.out.println(service.getAllProduct());
	return service.getAllProduct();
}

@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
@ResponseBody
public Products getProduct (@PathVariable String id)
{
	System.out.println(service.getProduct(id));
	return service.getProduct(id);
}

@RequestMapping(value="/products",method=RequestMethod.POST)
@ResponseBody
public boolean addNewProduct (@RequestBody Products product/*,@RequestParam String productLines*/)
{
	
	String  productLine = "Classic Cars";
	System.out.println("Adding Product"+ product + "in Product line "+productLine);
	return service.addNewProduct(product);
}

@RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
@ResponseBody
public boolean updateProduct (@RequestBody Products product,@PathVariable String id)
{
	boolean flag= service.updateProduct(id, product);
	return flag;
	
}
@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
@ResponseBody
public void deleteProduct (@PathVariable String id)
{
	service.deleteProduct(id);
	//return flag;
	
}
}
