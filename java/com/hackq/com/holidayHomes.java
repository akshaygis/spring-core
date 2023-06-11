package com.hackq.com;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class holidayHomes {
WebDriver driver =null ;
public static LocalDate tomorrow;
public static  LocalDate tomorrow1;

public String findDate(int n) {
	tomorrow=LocalDate.now().plusDays(n);
	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d MMMM yyyy");
	String date=tomorrow.format(formatter);
	return date;
}

    @Parameters("browser")
    @BeforeMethod

    public void OpenBrowser(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver","C:\\Users\\Tushar Khurana\\eclipse-workspace\\HackathonProject\\Drivers\\chromedriver.exe" );

            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.edge.driver","C:\\Users\\2266634\\eclipse-workspace\\ProjectHackathon\\Drivers\\msedgedriver.exe");

            driver = new EdgeDriver();

        }

        driver.manage().window().maximize() ;

     }

    @Test

    public void VerifyDiffrentTestCase() throws InterruptedException, IOException{

    	String baseurl="https://www.tripadvisor.in/";
		driver.get(baseurl);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");

		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//enter Nairobi in search box...
		driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[3]/div/div/div/form/input[1]")).sendKeys("nairobi");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add a missing place")));
		driver.findElement(By.className("EtzER")).click();

		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//click on holiday home...
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span[text()='Holiday homes']")));
		driver.findElement(By.xpath("//a/span[text()='Holiday homes']")).click();
		//Thread.sleep(2000);

		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//locate the calendar to scroll...
		WebElement Calender = driver.findElement(By.xpath("//*[@id=\"component_2\"]/div/div[4]/div/div[1]/div/div[1]/div[1]/div[4]/div/div/div[1]/h3"));
		js.executeScript("arguments[0].scrollIntoView();", Calender);
		
		driver.findElement(By.cssSelector("span.biGQs._P.fiohW.uWleQ")).click(); 
		//Thread.sleep(2000);
		
		//select date...
		tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
		String date = tomorrow.format(formatter);
		driver.findElement(By.xpath("//div[@aria-label='" +date+ "']")).click();
		
		tomorrow1 = LocalDate.now().plusDays(5);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d MMMM yyyy");
		String enddate = tomorrow1.format(formatter1);
		driver.findElement(By.xpath("//div[@aria-label='" +enddate+ "']")).click();
		//Thread.sleep(1000);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//to click on number of guests...
		driver.findElement(By.cssSelector("div.yzRfM.f")).click(); 
		//Thread.sleep(1000);
		
		
		//to increase the NUMBER OF GUESTS to 4...
		driver.findElement(By.xpath("//button[@title='increase']")).click();
		driver.findElement(By.xpath("//button[@title='increase']")).click();
		//Thread.sleep(1000);
		
		
		//clicking on Apply button...
		driver.findElement(By.xpath("//button/span[text()='Apply']")).click();
		//Thread.sleep(1000);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//clicking on TRIPADVISOR sort drop down;...
		driver.findElement(By.xpath("//span[text()='Tripadvisor Sort']")).click();
		//Thread.sleep(1000);
		
		
		//clicking on TRAVELLER RATING option...
		driver.findElement(By.xpath("//span[text()='Traveller Rating']")).click();
		//Thread.sleep(1000);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//scrolling to see Amenities option...
		WebElement Amenities  = driver.findElement(By.xpath("//h3[text()='Bedrooms']"));
		js.executeScript("arguments[0].scrollIntoView();", Amenities);
		//Thread.sleep(2000);
		
		
		//to click on SHOW ALL of amenities...
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[4]/div/div[1]/div/div[1]/div[1]/div[3]/div/div/div[2]/div/div[2]/button/span/div")).click();
		Thread.sleep(2000);
		
		
		//to click on elevator/lift option...
		driver.findElement(By.xpath("/html/body/div[14]/div/div[2]/div/div[2]/div[2]/span[9]/span/div[2]/label/span/span/span")).click();

		
		//Click on apply...
  		driver.findElement(By.xpath("//button/span[text()='Apply']")).click();
		Thread.sleep(4000);
  		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("*[@id=\"amenities.27_label\"]/span/span/span")));
  		
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//Get the list of top 3 holiday homes based on all the conditions given by the user...
		System.out.println("\n-------------------------------------------------");
		System.out.println("              HOLIDAY HOMES MODULE               ");
		System.out.println("-------------------------------------------------");
		
		//Storing the top 3 hotel names, price/night and price/4 nights in List <WebElements> ...
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='BMQDV _F G- wSSLS SwZTJ FGwzt ukgoS']")));
		List<WebElement> hotelNames1 = driver.findElements(By.xpath("//a[@class='BMQDV _F G- wSSLS SwZTJ FGwzt ukgoS']"));
		
		List<WebElement> perNightPrice = driver.findElements(By.xpath("//div[@class='biGQs _P fiohW veSeD']"));
		
		List<WebElement> totalPrice = driver.findElements(By.cssSelector(".ejdoA > div.biGQs._P.eVqsT.osNWb"));
		
		//Storing the data fetched into a 2D string array...
		String [][] hotelNames = new String[3][3];
		for(int r=0;r<3;r++)
		{
				hotelNames[r][0] = hotelNames1.get(r).getText();
				hotelNames[r][1] = perNightPrice.get(r).getText();
				hotelNames[r][2] = totalPrice.get(r).getText();
		}
		
		int rowlen = hotelNames.length;
		int colmlen = hotelNames[0].length;
System.out.println("check 0");
		//Displaying the data on console...
		for(int r=0;r<3;r++)
		{
				System.out.println(hotelNames[r][0] + " " + hotelNames[r][1] + " " + hotelNames[r][2]);
		}
 System.out.println("check 1");
		//Sending the data to an Excel file...
		XcelFunctions XF = new XcelFunctions(".//datafiles//output.xlsx");
		XF.writeData("HOTELS",rowlen,colmlen,hotelNames);
System.out.println("check 2");
      //Opening the cruise page...
//Opening the cruise page...
		System.out.println("\n-------------------------------------------------");
		System.out.println("                 CRUISE MODULE                   ");
		System.out.println("-------------------------------------------------");
		System.out.println("Opening tripadvisor cruises page : ");
		driver.get("https://www.tripadvisor.in/Cruises");

		System.out.println("Window handle of parent window i.e. Cruises page  : " + driver.getWindowHandle());

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Clicking on Cruise line drop down menu
		WebElement CruiseLineBtn = driver.findElement(By.xpath("//button[normalize-space()='Cruise line']"));
		CruiseLineBtn.click();
		// Wait for 0.5 seconds...
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Selecting Royal Caribbean cruise line...
		WebElement CruiseLineSelect = driver.findElement(By.id("menu-item-17391428"));

		// Scrolling down to the selected cruise line...
		Actions act = new Actions(driver);
		act.scrollToElement(CruiseLineSelect).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CruiseLineSelect.click();

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Clicking on Cruise ship drop down menu
		WebElement CruiseShipBtn = driver
				.findElement(By.cssSelector("#component_1 > div > div.iDcAX > div > div:nth-child(2) > div > button"));
		CruiseShipBtn.click();
		// Wait for 0.5 seconds...
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Selecting Symphony of the seas Cruise Ship...
		WebElement CruiseShipSelect = driver.findElement(By.id("menu-item-15691866"));

		// Scrolling down to the selected cruise ship...
		act.scrollToElement(CruiseShipSelect).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CruiseShipSelect.click();

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Clicking on the search button...
		WebElement SearchBtnClick = driver
				.findElement(By.cssSelector("#component_1 > div > div.iDcAX > div > div:nth-child(3) > span > button"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SearchBtnClick.click();

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Get details of parent and child windows
		Set<String> newAllWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = newAllWindowHandles.iterator();
		iterator.next(); // String mainWindow = iterator.next();
		String childWindow = iterator.next();

		// Switch control to child window i.e. the next opened tab...
		driver.switchTo().window(childWindow);
		System.out
				.println("Window handle of child window i.e. Cruises ship review page  : " + driver.getWindowHandle());

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Scroll down a little bit on the Ship page to reach Reviews section
		
		js.executeScript("window.scrollBy(0,2400)", "auto");

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Click on more button to get list of all the languages...
		driver.findElement(By.cssSelector("span[class='text']")).click();

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Retrieve all the languages offered and store in a List and display the
		// same...
		List<WebElement> allLanguages = driver.findElements(
				By.cssSelector("#BODY_BLOCK_JQUERY_REFLOW > div.VZmgo.D.X0.X1.Za > div > div.TocEc._Z.S2.H2._f > ul"));
		System.out.println();

		// allLanguages data is coming in 1 single unit : so rowlen size will be 1...
		int rowlen1 = allLanguages.size();
		int colmlen1 = 1;

		String[][] languages = new String[rowlen][1];

		// Displaying all the languages...
		int i = 0;
		for (WebElement link : allLanguages) {
			languages[i][0] = link.getText();
			System.out.println(languages[i][0]);
			i++;
		}

		// Sending languages data to the excel file...
		XcelFunctions XF1 = new XcelFunctions(".//datafiles//output.xlsx");
		XF1.writeData("CRUISE_LANGS", rowlen1, colmlen1, languages);

		// Wait for 1 second before closing the languages popup...
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Click on close button of languages...
		driver.findElement(By.cssSelector("div[aria-label='Close']")).click();

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Wait for 1 second before scrolling up to Overview section...
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Scroll up a little bit on the Ship page to reach Overview section...
		js.executeScript("window.scrollBy(0,-1600)", "auto");

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Display passengers, crew & launched year...
		List<WebElement> OverViewList = driver.findElements(By.className("szsLm"));
		System.out.println("\n");

		// allLanguages data is coming in 1 single unit : so rowlen size will be 1...
		int rowlen2 = OverViewList.size();
		System.out.println(rowlen1);
		int colmlen2 = 1;

		String[][] Overview = new String[rowlen][1];

		// Displaying all the languages...
		int x = 0; 
		for (WebElement link : OverViewList) {
			Overview[x][0] = link.getText();
			System.out.println(Overview[x][0]);
			i++;
		}

		// Sending languages data to the excel file...
		XF.writeData("CRUISE_OVERVIEW", rowlen2, colmlen2, Overview);
		
		System.out.println("\n\n");

		// Wait for 1 second before closing the pages...
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      
    }
}