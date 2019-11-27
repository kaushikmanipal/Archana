package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechrRgisterPOM {
private WebDriver driver; 
	
	public TechrRgisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"login-block\"]/div/ul/li[1]/a")
	private WebElement signUplnk; 
	
	@FindBy(xpath="/html/body/main/section/div/div[2]/div/form/fieldset/div[1]/div[1]/div[2]/label/input")
	private WebElement teachRadioBtn; 
	
	@FindBy(xpath="//*[@id=\"registration_firstname\"]")
	private WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"registration_lastname\"]")
	private WebElement lastName; 
	
	@FindBy(xpath="//*[@id=\"registration_email\"]")
	private WebElement eMail; 
	
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement userName; 
	
	@FindBy(xpath="//*[@id=\"pass1\"]")
	private WebElement passWord; 
	
	@FindBy(xpath="//*[@id=\"pass2\"]")
	private WebElement confmPaswd; 
	
	@FindBy(xpath="//*[@id=\"registration_phone\"]")
	private WebElement phoneNo; 
	
	@FindBy(xpath="//*[@id=\"registration_submit\"]")
	private WebElement registerBtn; 
	
	
	
	public void signUplnk() {
		this.signUplnk.click();
	}	
	
	public void teachRadioBtn() {
		//Actions action = new Actions(driver);
		//WebElement element = teachRadioBtn;
		//action.moveToElement(element).click(element).build().perform();
		teachRadioBtn.submit();
		System.out.println("clicked on radio button");
	}
		
	public void sendfirstName(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
	
	public void sendlastName(String lastName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lastName); 
	}
	
	public void sendeMail(String eMail) {
		this.eMail.clear(); 
		this.eMail.sendKeys(eMail); 
	}
	
	public void sendUsername(String userName) {
		this.userName.clear(); 
		this.userName.sendKeys(userName); 
	}
	
	public void sendpassWord(String passWord) {
		this.passWord.clear(); 
		this.passWord.sendKeys(passWord); 
	}
	
	public void sendconfmPaswd(String confmPaswd) {
		this.confmPaswd.clear(); 
		this.confmPaswd.sendKeys(confmPaswd); 
	}
	
	public void sendphoneNo(String phoneNo) {
		this.phoneNo.clear(); 
		this.phoneNo.sendKeys(phoneNo); 
	}
	
	public void clickregisterBtn() {
		this.registerBtn.click(); 
	}
}


