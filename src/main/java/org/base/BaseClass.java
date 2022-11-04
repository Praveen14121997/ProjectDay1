package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserName) {
		
		
		switch (browserName) {
		
		//browserLaunch
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		
			
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		}
		return driver;
		
	}
	
	
	    //url launch
     	public static void launchUrl(String url) {
	    	driver.get(url);
            driver.manage().window().maximize();
      
		}
		
     	//wait
     	public static void implicityWait(long sec) {
        	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
       
		}
        
        //getTitle
     	public static String getTitle() {
        	String title = driver.getTitle();
			return title;
 
		}
     	
     	//getCurrentUrl
     	public static String getCurrentUrl() {
     		String url = driver.getCurrentUrl();
			return url;

		}
     	
     	//close
     	public static void close() {
     		driver.close();

		}
     	
     	//sendKeys
     	public static void sendKeys(WebElement e,String name) {
     		e.sendKeys(name);

		}
     	
     	//click
     	public static void click(WebElement e ) {
     		e.click();

		}
     	
     	//getText
     	public static String getText(WebElement e ) {
     		String text=e.getText();
			return text;

		}
     	
     	//getAttribute
     	public String getAttribute(WebElement e) {
			String attribute = e.getAttribute("value");
			return attribute;
     		
     	}
     	
     	//Actions 
     	//moveToElement 
     	public static void moveElement(WebElement e ) {
     		Actions a=new Actions(driver);
     		a.moveToElement(e).perform();
     		

		}
     	
     	//dragAndDrop
     	public static void dragAndDrop(WebElement e1,WebElement e2) {
     		Actions a=new Actions(driver);
     		a.dragAndDrop(e1, e2).perform();
     		
     	}
     	
     	//select
     	//selectByIndex
     	public static void selectByIndex(WebElement e,int index) {
     		Select s=new Select(e);
     		s.selectByIndex(index);

		}
     	
     	//findElement
     	public static  WebElement findElement(String locatorName,String value) {
     		
     		WebElement values = null;
     		
			if(locatorName.equals("id")) {
     			values = driver.findElement(By.id(value));
     		}
			return values;
			
			

		}
     	
     	
     	
     	
     	
}
