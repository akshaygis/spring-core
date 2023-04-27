package com.akshay.test.anaconda;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
public static void main(String [] args) {
	ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/akshay/test/anaconda/construct.xml");
	Employee emp=(Employee) ctx.getBean("emp");
	System.out.println("Employee ID: " + emp.getId());
	System.out.println("Employee Name: "+ emp.getName());
}

}
