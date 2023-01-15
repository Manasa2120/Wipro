package com.Test.PageTest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Test.Basetest.BaseTest;
import com.Test.Utility.ExcelReader;

public class LoginTest extends BaseTest{
	//(invocationCount = 3)
	
	@Test(dataProvider="mydp")
	public void log(String uname, String pass) {
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
		
	}
	
	
	@DataProvider(name="mydp")
	public Object [][]getData() throws IOException{
	String path="C:\\Users\\User\\Documents\\WiproWorks\\Wipro\\WiproTensNG\\testData\\loginData.xlsx";
	
	ExcelReader reader=new ExcelReader(path);
	int totalrow=reader.getRowCount(path, "Sheet1");
	int totalcell=reader.getCellCount(path, "Sheet1",1);
	
    String	data[][]=new String [totalrow][totalcell];
 
	for(int i=1;i<=totalrow;i++) {
		for(int j=0;j<totalcell;j++) {
		data[i-1][j]=	reader.getCellData(path, "Sheet1", i, j);
		
		}
	}
	return data;
	
		
		
	}

}
