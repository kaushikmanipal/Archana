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
import com.training.pom.TechrRgisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.generics.*;

public class ELTC_005Test {
	private WebDriver driver;
	private String baseUrl;
	private TechrRgisterPOM techRegitPOM;
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
		techRegitPOM = new TechrRgisterPOM(driver);
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
		techRegitPOM.signUplnk();
		techRegitPOM.teachRadioBtn();
		techRegitPOM.sendfirstName("Teacher17");
		techRegitPOM.sendlastName("test");
		techRegitPOM.sendeMail("Teacher123@gmail.com");
		techRegitPOM.sendUsername("Teach17");
		techRegitPOM.sendpassWord("test123");
		techRegitPOM.sendconfmPaswd("test123");
		techRegitPOM.sendphoneNo("1234567890");
		techRegitPOM.clickregisterBtn();
		screenShot.captureScreenShot("First");
		genMeth.assertText("Dear test17 test,\r\n" + 
				"\r\n" + 
				"Your personal settings have been registered.", "//*[@id=\"cm-content\"]/div/div[2]/div/p[1]", "xpath", "Pass");
	}
}
