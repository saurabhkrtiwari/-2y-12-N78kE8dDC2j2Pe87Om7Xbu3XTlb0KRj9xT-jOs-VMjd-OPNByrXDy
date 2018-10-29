package com.Eretail.exceptions;

import org.springframework.dao.DataAccessException;

public class ProductLineNotFoundException extends DataAccessException {

	public ProductLineNotFoundException(String msg) {
		super("No Product Found");
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5404232465904201126L;

}
