package com.selenuim.basic;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Test
public class firstseleniumclass {
	WebDriver driver=null;
	
		@Parameters("browser")
		@BeforeMethod
	public void openBrowser(String browser) {
		//open the url with selenium
			if(browser.equalsIgnoreCase("chrome")) {
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\2266634\\eclipse-workspace\\FirstSeleniumProject\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		//to maximize the browser 
	    driver.manage().window().maximize();
	}else if(browser.equalsIgnoreCase("Edge")) {
	    System.setProperty("webdriver.Edge.driver","C:\\Users\\2266634\\eclipse-workspace\\FirstSeleniumProject\\Driver\\msedgedriver.exe");
	    driver=new ChromeDriver();
		//to maximize the browser 
	    driver.manage().window().maximize();
	}
		}
public void test() {
	String url="https://www.trivago.in";   
	driver.get(url);
	
	
	
	//Verify Homepage tittle
	String pageTitle=driver.getTitle();
    System.out.println("We get the Title Like :" +pageTitle);
   // Assert.assertEquals(pageTitle,"trivago.in - Compare hotel prices worldwide");
    
    //to close the web browser
    driver.close();
    
	
	
}


}
