package com.htc.seleniumacademyPOM.page;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.htc.seleniumacademyPOM.test.CheckOutTest;

public class CheckOutPage {
	protected WebDriver driver;
	
	private By addressDropdownBy=By.xpath("//*[@id=\"billing-address-select\"]");
	private By selectNewAddressBy=By.xpath("//*[@id=\"billing-address-select\"]/option[2]");
	private By setStreetAddressBy =By.cssSelector("[title='Street Address']");
	private By setCityBy =By.cssSelector("[title='City']");
	private By selectCountryBy =By.xpath("//*[@id=\"billing:country_id\"]/option[102]");
	private By setStateBy =By.cssSelector("[id=\"billing:region\"]");
	private By setZcodeBy =By.cssSelector("[name='billing[postcode]']");
	private By setTelephoneBy =By.cssSelector("[id=\"billing:telephone\"]");
	private By selectBillConituneBtnBy =By.cssSelector("button[title='Continue']");
	private By selectPaymentConituneBtnBy =By.cssSelector("[onclick='payment.save()']");
	private By selectPlaceOrderBtnBy =By.cssSelector("[class='button btn-checkout']");
	
	
	public CheckOutPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickDropBox() {
		driver.findElement(addressDropdownBy).click();
		
	}

	public void selectNewAddress() {
		driver.findElement(selectNewAddressBy).click();
		
	}

	public void setStreetAddress(String address) {
		WebElement addressEle=driver.findElement(setStreetAddressBy);
		addressEle.clear();
		addressEle.sendKeys(address);
		
	}
	public void setCity(String city) {
		WebElement addressEle1=driver.findElement(setCityBy);
		addressEle1.clear();
		addressEle1.sendKeys(city);
		
	}
	public void selectCountry() {
		driver.findElement(selectCountryBy).click();
		
	}
	public void setState(String state) {
		WebElement addressEle2=driver.findElement(setStateBy);
		addressEle2.clear();
		addressEle2.sendKeys(state);
		
	}
	public void setZcode(String zip) {
		WebElement addressEle3=driver.findElement(setZcodeBy);
		addressEle3.clear();
		addressEle3.sendKeys(zip);
		
	}
	public void setTelephone(String tel) {
		WebElement addressEle4=driver.findElement(setTelephoneBy);
		addressEle4.clear();
		addressEle4.sendKeys(tel);
	}
	public void clickBillContinueButton() {
		driver.findElement(selectBillConituneBtnBy).click();
		
	}
	public void clickPaymentContinueButton() {
		driver.findElement(selectPaymentConituneBtnBy).click();
		
	}
	public void clickOrderReviewContinueButton() {
		driver.findElement(selectPlaceOrderBtnBy).click();
		
	}
}
