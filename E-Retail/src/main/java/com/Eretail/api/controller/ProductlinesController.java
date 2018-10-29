package com.Eretail.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.services.ProductLineServiceInterface;

@RestController
@Transactional
public class ProductlinesController {

	@Autowired
	ProductLineServiceInterface service;
	
	/* (non-Javadoc)
	 * @see com.Eretail.api.controller.ProductLineService#getAllProductLines()
	 */
	@RequestMapping(value="/productLines",method=RequestMethod.GET)
	@ResponseBody
	public List<Productlines> getAllProductLines ()
	{
		return service.getAllProductLines();
	}
	
	/* (non-Javadoc)
	 * @see com.Eretail.api.controller.ProductLineService#getProductLine(java.lang.String)
	 */
	@RequestMapping(value="/productLines/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Productlines getProductLine (@PathVariable String id)
	{
		return service.getProductLine(id);
	}
	
	/* (non-Javadoc)
	 * @see com.Eretail.api.controller.ProductLineService#addNewProductLines(com.Eretail.api.model.Productlines)
	 */
	@RequestMapping(value="/productLines",method=RequestMethod.POST)
	@ResponseBody
	public boolean addNewProductLines (@RequestBody Productlines catagory)
	{
		
		return service.addNewProductLines(catagory);
	}
	
	/* (non-Javadoc)
	 * @see com.Eretail.api.controller.ProductLineService#updateProductLines(java.lang.String, com.Eretail.api.model.Productlines)
	 */
	
	@RequestMapping(value="/productLines/{id}",method = RequestMethod.PUT)
	@ResponseBody()
	public void updateProductLines(@PathVariable String id,@RequestBody Productlines t)
	{		
		service.updateProductLines(id, t);		
		
	}

	/* (non-Javadoc)
	 * @see com.Eretail.api.controller.ProductLineService#deleteProductLines(java.lang.String)
	 */
	@RequestMapping(value="/productLines/{id}",method = RequestMethod.DELETE)
	@ResponseBody()
	public void deleteProductLines(@PathVariable Productlines id)
	{		
		service.deleteProductLines(id);
	}
}
