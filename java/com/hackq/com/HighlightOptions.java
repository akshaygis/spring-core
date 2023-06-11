package com.hackq.com;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightOptions {
	
	public void flash(WebElement element, WebDriver driver) throws InterruptedException {
	    String originalBorderStyle = element.getCssValue("border");
	    
	    	setBorder("4px dashed red", element, driver);
	    	Thread.sleep(500);
	        setBorder(originalBorderStyle, element, driver);
	}

	public void setBorder(String borderStyle, WebElement element, WebDriver driver) throws InterruptedException {
	    JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].style.border = '" + borderStyle + "'", element);
	    Thread.sleep(20);
	}
	
}