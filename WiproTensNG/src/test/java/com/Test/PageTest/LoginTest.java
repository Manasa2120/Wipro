package com.Test.PageTest;

import org.testng.annotations.Test;

import com.Test.Basetest.BaseTest;

public class LoginTest extends BaseTest{
	
	
	@Test(invocationCount = 3)
	public void loginTest() {
		
		System.out.println("Login");
		
	}

}
