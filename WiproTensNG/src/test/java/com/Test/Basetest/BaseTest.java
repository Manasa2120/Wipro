package com.Test.Basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	
	
	@BeforeSuite
	public void setUp() throws FileNotFoundException, IOException, Exception {
		
		
		
		prop=new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Config\\confi.properties")));
		
		if(prop.getProperty("browser").equals("Chrome")){
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("FireFox")){
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
       else if(prop.getProperty("browser").equals("IE")){
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
       else if(prop.getProperty("browser").equals("Edge")){
			
   			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Driver\\sedgedriver.exe");
   			driver=new EdgeDriver();
   		}
       else {
    	   System.out.println("Invalid Browser Selected");
    	   System.exit(0);
       }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("appurl"));
		
	}

		

	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
