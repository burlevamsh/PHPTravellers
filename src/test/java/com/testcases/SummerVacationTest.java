package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.Pages;
import com.pages.XLSLFile;

public class SummerVacationTest {

	WebDriver driver;
	Pages page;
	
	@BeforeSuite
	public void before_suite() {
		//set the path of the driver
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
	}
	
	@BeforeTest
	public void beforeTest() {
		//Getting start using of chrome browser
		driver=new ChromeDriver();
		//URL to be loaded on the browser
		driver.get("https://www.phptravels.net/offers");
		//maximize the window
		driver.manage().window().maximize();
		//Wait until the elemet is find. 
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		page=new Pages(driver);
	}
	
	@DataProvider(name="dp")
	public Object[][] testData(){
		return XLSLFile.getXLSXFile("C:\\Users\\my laptop\\eclipse-workspace\\PHPTravellers\\TestData.xlsx");
	}
	
	@Test(dataProvider="dp")
	public void vaccationTest(String name,String password,String message) throws InterruptedException {
	
		//page.dropdown();
		Thread.sleep(10000);
		page.moveToOffersPage();
		Thread.sleep(10000);
		page.dropdown();
		Thread.sleep(10000);
		page.name(name);
		String a=(String) password.subSequence(3,13);
		page.phone(a);
	//	Thread.sleep(10000);
		page.message(message);
		}
}
