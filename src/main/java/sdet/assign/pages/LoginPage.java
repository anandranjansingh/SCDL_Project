package sdet.assign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdet.assign.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="login")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign up')]")
	private WebElement sinUpLink;
	
	
	public void doLogin(String uNm, String pwd) {
		username.sendKeys(uNm);
		password.sendKeys(pwd);
		submitBtn.click();
	}
	
	public SignUpPage goToSignUp() {
		sinUpLink.click();
		return new SignUpPage();		
	}
	
}
