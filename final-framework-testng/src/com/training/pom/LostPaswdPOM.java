package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostPaswdPOM {
private WebDriver driver; 
	
	public LostPaswdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"login-block\"]/div/ul/li[2]/a")
	private WebElement ilostpaswd; 
	
	@FindBy(xpath="//*[@id=\"lost_password_user\"]")
	private WebElement userName;
	
	@FindBy(xpath="//*[@id=\"lost_password_submit\"]")
	private WebElement sendMsgBtn; 
	
	public void clickIlostpaswd() {
		this.ilostpaswd.click();
	}
	
	public void sendUsername(String userName) {
		this.userName.clear(); 
		this.userName.sendKeys(userName); 
	}
	
	public void clickSendMsgBtn() {
		this.sendMsgBtn.click(); 
	}
}


