package com.cg.customer.dao;

import java.util.List;

import com.cg.customer.bean.Customer;
import com.cg.customer.exception.CustomerException;

public interface ICustomerDao {

	void addDetails(Customer bean);

	List<Customer> retrieveDetails();

	Customer retrieveById(int id) throws CustomerException;

	Customer retrieveByMobile(Long mobile) throws CustomerException;


}
