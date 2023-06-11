package com.hackq.com;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {

	private static WebDriver driver = null;

	public static WebDriver OpenBrowser() throws InterruptedException, FileNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser : (chrome/edge/firefox) : ");
		String browser = sc.next();

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				
				// create object of web driver
				ChromeOptions co = new ChromeOptions();
				co.addArguments("start-maximized");
				co.addArguments("--disable-blink-features=AutomationControlled");
				co.addArguments("--disable-notifications");// Disabling any notifications
				driver = new ChromeDriver(co);
			}
			else if (browser.equalsIgnoreCase("edge")) {
				
				// create object of web driver
				EdgeOptions e = new EdgeOptions();
				e.addArguments("start-maximized");
				e.addArguments("--disable-blink-features=AutomationControlled");
				e.addArguments("--disable-notifications");// Disabling any notifications
				driver = new EdgeDriver(e);
			}
			else if (browser.equalsIgnoreCase("Firefox")) {
				
				// create object of web driver
				FirefoxOptions fo = new FirefoxOptions();
				driver = new FirefoxDriver(fo);
			} 
			else {
				throw new IllegalArgumentException("Invalid browser name");
			}
		} catch (Exception e) {
			System.out.println("We couldn't find the requested browser : opening edge by default");

			EdgeOptions e1 = new EdgeOptions();
			driver = new EdgeDriver(e1);
		}
			// To maximize the browser.
			driver.manage().window().maximize();

		return driver;
	}
}