package sdet.assign.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdet.assign.base.TestBase;

public class SignUpPageAcknowledgementPage extends TestBase{
	
	public SignUpPageAcknowledgementPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement profileDD;
		
	@FindBy(xpath="//p[contains(text(),'Dear')]")
	WebElement ackMssg;
	
	@FindBy(xpath="//p[contains(text(),'.com')]")
	WebElement emailId;
	
	@FindBy(id="logout_button")
	WebElement logOutBtn;
	
	@FindBy(xpath="//a[@title='Homepage']")
	WebElement homePgLink;
	
	
	public String getAckMssg() {
		return ackMssg.getText().replaceAll("\\r\\n|\\r|\\n","");
	}
	
	public void clickProfileIcon() {
		profileDD.click();
	}
	
	public HomePage gotoHomePg() {
		homePgLink.click();
		return new HomePage();		
	}
	
	public String getEmailId() throws InterruptedException {
		//profileDD.click();
		Thread.sleep(3000);
		return emailId.getText();
	}
	
	public LoginPage doLogout() throws InterruptedException {
		Thread.sleep(1000);
		logOutBtn.click();
		Thread.sleep(2000);
		return new LoginPage();
	}	
	
	
}

