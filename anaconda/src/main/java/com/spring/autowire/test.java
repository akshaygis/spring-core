package com.spring.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class test {

	public static void main(String[] args) {
		
 ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/autowire/configi.xml");
 emp emp1=context.getBean("emp1",emp.class);
 System.out.println(emp1);
	}

}
