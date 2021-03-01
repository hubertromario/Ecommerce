package com.htc.seleniumacademyPOM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	protected WebDriver driver;
	private By selectList=By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");	
	private By selectOption=By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[2]/a");//By.xpath("//*[@id=\"nav\"]/ol/li[4]/child::ul/child::li/child::a[text()=\"Books & Music\"]");
		
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	public void clickandSelectList() {
		WebElement list1=driver.findElement(selectList);
		Actions ac=new Actions(driver);
		ac.moveToElement(list1).perform();
	}
	public void clickBooksOption() {
		driver.findElement(selectOption).click();
	}
	

}
