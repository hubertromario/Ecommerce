package com.htc.seleniumacademyPOM.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.htc.base.ExtentTestManager;
import com.htc.seleniumacademyPOM.page.AddToCartPage;
import com.htc.seleniumacademyPOM.page.BooksPage;
import com.htc.seleniumacademyPOM.page.CartPage;
import com.htc.seleniumacademyPOM.page.CheckOutPage;
import com.htc.seleniumacademyPOM.page.HomePage;
import com.htc.seleniumacademyPOM.page.LoginPage;
import com.htc.seleniumacademyPOM.page.ReadExcelFile;
import com.htc.seleniumacademyPOM.page.RegistrationPage;
import com.htc.seleniumacademyPOM.page.SuccessPage;

public class CheckOutTest {
	RegistrationPage rpage = null;
	HomePage hpage = null;
	LoginPage lpage = null;
	BooksPage bpage=null;
	CartPage cpage=null;
	AddToCartPage apage=null;
	CheckOutPage copage=null;
	SuccessPage spage=null;
	WebDriver driver = null;
	

	Properties data=null;

	@BeforeClass
	public void loadProptiesFile()
	{
		data=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\huber\\Desktop\\FullEcomPom\\src\\test\\resources\\apps.properties");
			data.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void setup() {
		System.setProperty("chromedriver", "C:\\Users\\huber\\Desktop");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hpage=new HomePage(driver);
		lpage=new LoginPage(driver);
		bpage=new BooksPage(driver);
		apage=new AddToCartPage(driver);
		cpage=new CartPage(driver);
		copage=new CheckOutPage(driver);
		spage=new SuccessPage(driver);
		driver.get(hpage.getURL());
	}

	@AfterMethod
	public void tearDown() {
		//chromeDriver.close();
	}
	@DataProvider(name = "ecomLogin_valid")
	public Object[][] ecomStoreSigninValidData()
	{

		ReadExcelFile ref= new ReadExcelFile(data.getProperty("datarepository.ecomstore.signin"));

		Object[][] loginDataSet=ref.getRecords(data.getProperty("datarepository.ecomstore.signin.sheetname.valid"));

		System.out.println("test"+loginDataSet.length);
		return loginDataSet;

	}


	@Test(dataProvider ="ecomLogin_valid" )
	public void testLoginPage_enterCredantials_shouldLoginSuccessful(String ... parameters) {

		String email=parameters[0];
		String password=parameters[1];

		hpage.loginWithCredantials(email, password);
		lpage.clickandSelectList();
		lpage.clickBooksOption();
		
		bpage.selectBookFromList();
		
		apage.selectQuantity();
		apage.selectCheckBox();
		apage.clickAddtoCartButton();
		
		cpage.clickProceedButton();
		
		copage.clickDropBox();
		copage.selectNewAddress();
		copage.setStreetAddress(data.getProperty("address"));
		copage.setCity(data.getProperty("city"));
		copage.selectCountry();
		copage.setState(data.getProperty("state"));
		copage.setZcode(data.getProperty("zcode"));
		copage.setTelephone(data.getProperty("tel"));
		copage.clickBillContinueButton();
		copage.clickPaymentContinueButton();
		copage.clickOrderReviewContinueButton();
		
		
	Assert.assertEquals(spage.SuccessMsg(),"THANK YOU FOR YOUR PURCHASE!");


	}
//	@Test
//	public void baseTest1() {
//		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
//		System.out.println("Hey im in test1 test");
//		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 1");
//		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 2");
//		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 3");
//		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 4");
//	}
//	

}
