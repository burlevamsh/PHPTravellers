package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	WebDriver driver;
	public Pages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//span[@class='ink animate']")
	WebElement dropdown;
	
	@FindBy(xpath ="/html/body/div[2]/div[1]/div[1]/section/div/div/div[2]/div/div/div[7]/div/div[2]/div/div[3]/div/div/a")
	WebElement readMore;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder='Phone']")
	WebElement phone;
	
	@FindBy(xpath="//textarea[@placeholder='Message']")
	WebElement message;
	
	
	public void dropdown() {
		
		driver.findElement(By.xpath("//div[@class='dropdown dropdown-currency']//a[@id='dropdownCurrency']")).click();;
		
		
		Actions a1=new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//*[@id=\"header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[1]/div/div/div/a[4]"))).click().build().perform();
	}
	
	public void moveToOffersPage() {
		readMore.click();
	}
	
	public void name(String userName) {
		name.sendKeys(userName);
	}
	
	public void phone(String phoneNumber) {
		phone.sendKeys(phoneNumber);
	}
	
	public void message(String messageSent) {
		message.sendKeys(messageSent);
	}
	

}
