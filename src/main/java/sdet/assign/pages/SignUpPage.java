package sdet.assign.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdet.assign.base.TestBase;

public class SignUpPage extends TestBase{
	
	public SignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input/following-sibling::p[text()='Follow courses']")
	WebElement followCourses;
	@FindBy(xpath="//input/following-sibling::p[text()='Teach courses']")
	WebElement teachCourses;
	
	@FindBy(id="registration_firstname")
	WebElement firstNm;
	@FindBy(id="registration_lastname")
	WebElement lastNm;
	@FindBy(id="registration_email")
	WebElement email;
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="pass1")
	WebElement password;
	@FindBy(id="pass2")
	WebElement confirmPwd;
	@FindBy(id="registration_submit")
	WebElement registerBtn;
	
	@FindBy(xpath="//p[contains(text(),'An e-mail has been sent')]")
	WebElement registerConfirmMssg;
	
	@FindBy(id="registration_submit")
	WebElement registerBrdCrum;
	
	@FindBy(xpath="//li[@class='dropdown avatar-user']")
	WebElement profileIcon;
	
	@FindBy(xpath="//a[@title='Homepage']")
	WebElement hmPgLink;
	
	
	
	
	public void enterMandatoryData4Registration(String fNm, String lNm, String emailid, String userNm, String pwd, String cnfrmPwd) throws InterruptedException {
		Random rand=new Random();
		
		followCourses.click();
		
		firstNm.sendKeys(fNm);
		Thread.sleep(1000);
		lastNm.sendKeys(lNm);
		Thread.sleep(1000);
		email.sendKeys(emailid);
		Thread.sleep(1000);
		
		userName.sendKeys(userNm+rand.nextInt(10000));
		Thread.sleep(1000);
		password.sendKeys("Pass@Pass1");
		Thread.sleep(1000);
		confirmPwd.sendKeys("Pass@Pass1");
		Thread.sleep(2000);
		
		//userName.getText();
		
	}
	
	public SignUpPageAcknowledgementPage clickRegister() {
		registerBtn.click();
		return new SignUpPageAcknowledgementPage();
	}
	
	public void chkProfile() {
		profileIcon.click();
	}
	
//	public HomePage goToHmPg() {
//		hmPgLink.click();
//		return new HomePage();
//	}
	
	
}

