package com.cg.customer.ui;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.cg.customer.bean.Customer;
import com.cg.customer.exception.CustomerException;
import com.cg.customer.service.CustomerServiceImpl;
import com.cg.customer.service.ICustomerService;

public class CustomerUI {

	
	static ICustomerService service = null;
	static Customer bean = null;
	
	public static void main(String[] args) throws CustomerException {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		
		while(true){
			
			System.out.println("\n1.Add\n2.Find by id\n3.Find by mobile\n4.Retrieve");
			int choice = sc.nextInt();
			
			bean = new Customer();
			service = new CustomerServiceImpl();
			
			switch(choice){
			
			case 1:
				
				System.out.println("Enter your name");
				bean.setName(sc.next());
				
				System.out.println("Enter your mobile");
				bean.setMobile(sc.nextLong());
				
				System.out.println("Enter your email");
				bean.setEmail(sc.next());
				
				System.out.println("Enter date of birth in this format dd-MM-yyyy");
				String d = sc.next();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
					
				try {
					date =sdf.parse(d);
					bean.setBirthDate(date);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				service.addDetails(bean);
				System.out.println("Added");
				
				break;
				
			case 2:
				System.out.println("Enter the Id to be searched");
				int id = sc.nextInt();
				
				Customer c = service.retrieveById(id);
					
					System.out.print(c.getCustId()+"\t");
					System.out.print(c.getName()+"\t");
					System.out.print(c.getMobile()+"\t");
					System.out.print(c.getEmail()+"\t");
					System.out.println(c.getBirthDate());
				
				break;
				
			case 3:
				
				System.out.println("Enter the Mobile Number to be searched");
				Long mobile = sc.nextLong();
				
				Customer cmob = service.retrieveByMobile(mobile);
					
					System.out.print(cmob.getCustId()+"\t");
					System.out.print(cmob.getName()+"\t");
					System.out.print(cmob.getMobile()+"\t");
					System.out.print(cmob.getEmail()+"\t");
					System.out.println(cmob.getBirthDate());
				
				break;
				
			case 4:
				
				for(Customer cout:service.retrieveDetails()){
					
					System.out.print(cout.getCustId()+"\t");
					System.out.print(cout.getName()+"\t");
					System.out.print(cout.getMobile()+"\t");
					System.out.print(cout.getEmail()+"\t");
					System.out.println(cout.getBirthDate());
				}
				
				break;
			}
			
		}
		
		
		
	}

}
