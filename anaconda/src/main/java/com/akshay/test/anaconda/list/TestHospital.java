package com.akshay.test.anaconda.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHospital {

	public static void main(String[] args) {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("com/akshay/test/anaconda/list/hospitalconfig.xml");
	 Hospital hospital = (Hospital) context.getBean("hospital");
	 System.out.println(hospital.getName());
	 System.out.println(hospital.getDepartments());
	 
	
	
		
	}

}
