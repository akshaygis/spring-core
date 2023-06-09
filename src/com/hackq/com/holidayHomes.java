package com.hackq.com;
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

            System.setProperty("webdriver.chrome.driver","C:\\Users\\2266634\\eclipse-workspace\\ProjectHackathon\\Drivers\\chromedriver.exe" );

            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.edge.driver","C:\\Users\\2266634\\eclipse-workspace\\ProjectHackathon\\Drivers\\msedgedriver.exe");

            driver = new EdgeDriver();

        }

        driver.manage().window().maximize() ;

     }

    @Test

    public void VerifyDiffrentTestCase() throws InterruptedException{

        driver.get("https://www.tripadvisor.in");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement search=driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        search.sendKeys("nairobi");
        Thread.sleep(1000);
        //to click on the nairobi 
        driver.findElement(By.className("EtzER")).click();
        
        Thread.sleep(1000);
        //to select Holiday homes
        driver.findElement(By.xpath("//*[@id=\"lithium-root\"]/main/div[1]/div/div[1]/nav/div/div/div[1]/a[6]/span")).click();
        
        Thread.sleep(1000);
        //	to scroll until i get suitability option 
        WebElement toScroll=driver.findElement(By.xpath("//h3[normalize-space()='Suitability']"));
        js.executeScript("arguments[0].scrollIntoView();", toScroll);
        
        driver.findElement(By.xpath("//a/span[text()='Holiday homes']")).click();
        Thread.sleep(1000);

      //scroll until you can see suitability option
        WebElement toscrool = driver.findElement(By.xpath("//h3[text()='Suitability']"));
        js.executeScript("arguments[0].scrollIntoView();", toscrool);
        //click on calender
        driver.findElement(By.cssSelector("span.biGQs._P.fiohW.uWleQ")).click(); 
        Thread.sleep(1000);


        //creating Holiday home object
        holidayHomes obj = new holidayHomes();
        String tomorrowDate = obj.findDate(1);
        driver.findElement(By.xpath("//div[@aria-label='" +tomorrowDate+ "']")).click();
        Thread.sleep(1000);

        // for 5th day after tomorrow's date
        String endDate = obj.findDate(5);

        driver.findElement(By.xpath("//div[@aria-label='" +endDate+ "']")).click();

        Thread.sleep(1000); 
        
        //adding guest
        driver.findElement(By.cssSelector("#component_2 > div > div.cnrzg.Gi.Z.BC.f.t > div > div.fyJSg.f > div > div > div:nth-child(3) > div.KFWPn > button")).click();
        driver.findElement(By.xpath("//div[@class='ZSTqW f u Wg vfszC']//button[@title='increase']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//div[@class='ZSTqW f u Wg vfszC']//button[@title='increase']//*[name()='svg']")).click();
        
        //click on apply
        driver.findElement(By.xpath("//span[normalize-space()='Apply']")).click();
        Thread.sleep(1000);
        
        //dropdown rating 
        driver.findElement(By.xpath("//*[@id=\"component_2\"]/div/div[3]/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div/button/div/span[1]")).click();
        Thread.sleep(1000);
        //select rating from dropdown
        driver.findElement(By.xpath("//span[contains(text(),'Traveller Rating')]")).click();
        Thread.sleep(1000);
        
        //to scroll till bedroom is visible
        WebElement Amenities  = driver.findElement(By.xpath("//*[@id=\"component_2\"]/div/div[4]/div/div[1]/div/div[1]/div[1]/div[1]/div/div/div[1]/h3"));
        js.executeScript("arguments[0].scrollIntoView();",Amenities);
        Thread.sleep(1000);
         
        //to click on show all
        driver.findElement(By.xpath("//*[@id=\":component_2-R1l9icl:\"]/div/div[2]/button/span/div")).click();
        Thread.sleep(1000);
        //to click on elevator and apply
        driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div[2]/div/div[2]/div[2]/span[9]/span/div[1]/label/span")).click();
        Thread.sleep(1000);

         driver.findElement(By.cssSelector("#BODY_BLOCK_JQUERY_REFLOW > div.HyAcm.D.t._U.s.l.Za.f > div > div.HllFM.F- > div > div > button > span")).click();
        Thread.sleep(50000);
         // to make list of all the Hotels and there price
         WebElement item1 = null;
         WebElement item2 = null;
         WebElement item3 = null;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='BMQDV _F G- wSSLS SwZTJ FGwzt ukgoS']")));
        List<WebElement> hotelNames1 = driver.findElements(By.xpath("//a[@class='BMQDV _F G- wSSLS SwZTJ FGwzt ukgoS']"));
        List<WebElement> perNightPrice = driver.findElements(By.xpath("//div[@class='biGQs _P fiohW veSeD']"));
        List<WebElement> totalPrice = driver.findElements(By.cssSelector(".ejdoA > div.biGQs._P.eVqsT.osNWb"));

      
        for (int i = 0; i<3; i++)
        {
          item1  = hotelNames1.get(i);
          item2  = perNightPrice.get(i);
          item3  = totalPrice.get(i);
          System.out.println( item1.getText() + " , " + item2.getText() + " , " + item3.getText() );
        
            }
        Thread.sleep(1000);
     
      //Opening the cruise page...
        System.out.println("\n***************************************************************************************************************");
        System.out.println("<------------------------------------------------ CRUISE MODULE ------------------------------------------------->");
        System.out.println("*****************************************************************************************************************");
        System.out.println("Opening tripadvisor cruises page : ");
        driver.get("https://www.tripadvisor.in/Cruises");
        
        System.out.println("Window handle of parent window i.e. Cruises page  : " + driver.getWindowHandle());
        Thread.sleep(1000);
      //click on cruse line
        driver.findElement(By.xpath("//*[@id=\"component_1\"]/div/div[2]/div/div[1]/div")).click();
        
      //Selecting Royal Caribbean cruise line...
        WebElement CruiseLineSelect = driver.findElement(By.id("menu-item-17391428"));

        //Scrolling down to the selected cruise line..
        Actions act = new Actions(driver);
        act.scrollToElement(CruiseLineSelect).perform();
        Thread.sleep(1000);
        CruiseLineSelect.click();
        Thread.sleep(1000);
 System.out.println("yaha tak ho gya-0");
      
        //click on search
        driver.findElement(By.xpath("//*[@id=\"component_1\"]/div/div[2]/div/div[3]")).click();
        Thread.sleep(1000);
        
        //Get details of parent and child windows
          Set<String> newAllWindowHandles = driver.getWindowHandles();
          Iterator<String> iterator = newAllWindowHandles.iterator();
          iterator.next(); //String mainWindow = iterator.next();
          String childWindow = iterator.next();
          //Switch control to child window i.e. the next opened tab...
          driver.switchTo().window(childWindow);
          System.out.println("Window handle of child window i.e. Cruises ship review page  : " + driver.getWindowHandle());
          System.out.println("yaha tak ho gya-1");
          Thread.sleep(1000);
          //to scroll-down to print the languages
          js.executeScript("window.scrollBy(0,2400)", "auto");
          Thread.sleep(1000);
          
          
          //Retrieve all the languages offered and store in a List and display the same...
          List<WebElement> allLanguages = driver.findElements(By.cssSelector("span.ZmySZ"));
          System.out.println();
          //Displaying all the languages...
          for(WebElement link : allLanguages)
          {
          System.out.println(link.getText());
          }
          Thread.sleep(1000);
          
        //Scroll up a little bit on the Ship page to reach Overview section...
          js.executeScript("window.scrollBy(0,-1600)", "auto");
          
        //Display passengers, crew & launched year...
          List<WebElement> OverViewList = driver.findElements(By.className("szsLm"));
          System.out.println("\n");

          
          //Displaying all the languages...
          for(WebElement link : OverViewList)
          {
          System.out.println(link.getText());
          }
          System.out.println("\n\n");
  }
      
}
