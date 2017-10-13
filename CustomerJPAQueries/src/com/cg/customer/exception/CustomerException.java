package com.cg.customer.exception;

import java.util.Date;

public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Long data;

	public CustomerException(int custId) {
		// TODO Auto-generated constructor stub
		data = (long) custId;
	}
	
	public CustomerException(Long mobile) {
		// TODO Auto-generated constructor stub
		data = mobile;
	}

	@Override
	public String toString() {
		return "This input data " + data + " is not in Database";
	}

	
	
	
	
}
