package com.Eretail.api.model.DAO;

import java.net.URLDecoder;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Eretail.api.model.Productlines;

@Repository
@Transactional
public class ProductLineDAOImp implements ProductLineDAO{
@PersistenceContext
	private EntityManager e;
	@Autowired
	private SessionFactory factory;
	
	private Session getSession()
	{
		return factory.getCurrentSession();
	}
	
	@Override
	public List<Productlines> getAllProductLines() {
		@SuppressWarnings("unchecked")
		List<Productlines> list = getSession().createQuery("from Productlines").list();
		return list;
		/*List<Productlines> list =e.createQuery("from Productlines p ").getResultList();
		return list;*/
	}

	@Override
	public Productlines getProductLine(String id) {
		
		return (Productlines) getSession().get(Productlines.class, id);
	}

	@Override
	public boolean addNewProductLines(Productlines catagory) {
	getSession().save(catagory);
		return true ;
	}

	@Override
	public void updateProductLines(String id, Productlines t) {
		Productlines p = getSession().get(Productlines.class, id);
		p.setHtmlDescription(t.getHtmlDescription());
		
	}

	@Override
	public void deleteProductLines(Productlines p) {
		getSession().delete(p);;
		
		
	}

	@Override
	public void deleteProductLines(String id) {
		// TODO Auto-generated method stub
		
	}

}
