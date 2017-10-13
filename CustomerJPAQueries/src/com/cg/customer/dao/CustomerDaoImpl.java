package com.cg.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.customer.bean.Customer;
import com.cg.customer.exception.CustomerException;
import com.cg.customer.util.Utility;

public class CustomerDaoImpl implements ICustomerDao{


	EntityManager entityManager = Utility.getEntityManager();

	@Override
	public void addDetails(Customer bean) {
		// TODO Auto-generated method stub
		
		entityManager.getTransaction().begin();
		entityManager.persist(bean);
		entityManager.getTransaction().commit();
	
	}

	@Override
	public List<Customer> retrieveDetails() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = (TypedQuery<Customer>) entityManager.createNamedQuery("getAllCustomers");
		List<Customer> custList = query.getResultList();
		
		return custList;
	}

	@Override
	public Customer retrieveById(int custId) throws CustomerException {
		
		Customer customer = null;
		customer = entityManager.find(Customer.class, custId);
		
		if(customer == null){
			
			throw new CustomerException(custId);
		}
		return customer;
		
	}

	@Override
	public Customer retrieveByMobile(Long mobile) throws CustomerException {
		// TODO Auto-generated method stub
		Customer mobList = null;
		try{
			String findByMobile = "SELECT cust FROM Customer cust WHERE cust.mobile=:cMobile";
			
			
			TypedQuery<Customer> query = (TypedQuery<Customer>) entityManager.createQuery(findByMobile, Customer.class);
			query.setParameter("cMobile", mobile);
			mobList = query.getSingleResult();
		}
		catch(Exception e){
	
			throw new CustomerException(mobile);
		}
		
		return mobList;
	}

	
	
	
}
