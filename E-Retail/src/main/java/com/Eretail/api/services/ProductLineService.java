package com.Eretail.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eretail.api.model.Productlines;
import com.Eretail.api.model.DAO.ProductLineDAOImp;

@Service
public class ProductLineService implements ProductLineServiceInterface {

	@Autowired
private ProductLineDAOImp dao;
	private static final Logger logger = LogManager.getLogger(ProductLineService.class);
	List<Productlines> productLines = new ArrayList<>(Arrays.asList(
			new Productlines("ClassicCars","description","Html Description"),
			new Productlines("Bikes","description","Html Description"),
			new Productlines("Racing Cars","description","Html Description"),
			new Productlines("Vintage Cars","description","Html Description")
	)); 
	
	@Override
	public List<Productlines> getAllProductLines() {
		logger.info("==============================================================================");
		logger.info("::::::::::::::::::Fetched Records::::::::::::::::::::: "+productLines.size());
		logger.info("==============================================================================");
		return dao.getAllProductLines();
	}

	@Override
	public Productlines getProductLine(String id) {
		Productlines p = dao.getProductLine(id);
		System.out.println(p.getProductses().size());
		logger.info("==============================================================================");
		logger.info(":::::::::::::::::: Fetched Record::::::::::::::::::::: ");
		logger.info(p.toString());
		logger.info("==============================================================================");
		return p;
		
	}

	@Override
	public boolean addNewProductLines(Productlines catagory) {
		boolean flag = dao.addNewProductLines(catagory);	
		logger.info("==============================================================================");
		logger.info(":::::::::::::::::: Added Record::::::::::::::::::::: ");
		logger.info(catagory.toString());
		logger.info("==============================================================================");
		return flag;
	}

	@Override
	public void updateProductLines(String id, Productlines t) {
		dao.updateProductLines(id, t);	
		
		logger.info("==============================================================================");
		logger.info(":::::::::::::::::: Updated Record::::::::::::::::::::: ");
		//logger.info(p.toString());
		logger.info("==============================================================================");
		
	}

	@Override
	public void deleteProductLines(Productlines p) {
		dao.deleteProductLines(p);
		logger.info("==============================================================================");
		logger.info(":::::::::::::::::: Deleted Record::::::::::::::::::::: ");
		logger.info(productLines.size());
		logger.info("==============================================================================");
		
	}

}
