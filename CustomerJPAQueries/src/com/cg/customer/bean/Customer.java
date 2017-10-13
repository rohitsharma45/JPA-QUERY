package com.cg.customer.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Table(name = "Customer")

@NamedQueries(@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Customer cust"))
public class Customer implements Serializable {

	@Id
	@Column(name = "custId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE2")
	@SequenceGenerator(name="SEQUENCE2", sequenceName="CUSTOMER_ID_SEQ", allocationSize=10)
	private int custId;
	
	@Column(name = "custName")
	private String custName; 
	
	@Column(name = "mobile")
	private Long mobile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthDate")
	private Date birthDate;
	
	private static final long serialVersionUID = 1L;

	
	
	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getName() {
		return custName;
	}


	public void setName(String name) {
		this.custName = name;
	}


	public Long getMobile() {
		return mobile;
	}


	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date date) {
		this.birthDate = date;
	}


	public Customer() {
		super();
	}
   
}
