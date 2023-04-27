package com.akshay.externalisation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String [] args) {
		ApplicationContext con= new ClassPathXmlApplicationContext("com/akshay/externalisation/configi.xml");
		Myda dao=(Myda) con.getBean("myDa");
		System.out.println(dao);
	}
}