package com.cg.customer.service;


import java.util.List;

import com.cg.customer.bean.Customer;
import com.cg.customer.dao.CustomerDaoImpl;
import com.cg.customer.dao.ICustomerDao;
import com.cg.customer.exception.CustomerException;

public class CustomerServiceImpl implements ICustomerService{

	ICustomerDao dao = new CustomerDaoImpl();

	@Override
	public void addDetails(Customer bean) {
		// TODO Auto-generated method stub
		dao.addDetails(bean);
	}

	@Override
	public List<Customer> retrieveDetails() {
		// TODO Auto-generated method stub
		return dao.retrieveDetails();
	}

	@Override
	public Customer retrieveById(int id) throws CustomerException {
		// TODO Auto-generated method stub
		return dao.retrieveById(id);
	}

	@Override
	public Customer retrieveByMobile(Long mobile) throws CustomerException {
		// TODO Auto-generated method stub
		return dao.retrieveByMobile(mobile);
	}
}
