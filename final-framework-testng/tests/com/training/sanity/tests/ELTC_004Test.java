package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.LostPaswdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.generics.*;

public class ELTC_004Test {
	private WebDriver driver;
	private String baseUrl;
	private LostPaswdPOM lostPswdPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genMeth;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		lostPswdPOM = new LostPaswdPOM(driver);
		genMeth = new GenericMethods(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		genMeth.assertURL("http://elearningm1.upskills.in/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		lostPswdPOM.clickIlostpaswd();
		lostPswdPOM.sendUsername("reva");
		lostPswdPOM.clickSendMsgBtn(); 
		screenShot.captureScreenShot("First");
		genMeth.assertText("Your password has been emailed to you", "//*[@id=\"cm-content\"]/div/div[2]/div[1]/div/div", "xpath", "Pass");
	}
}
