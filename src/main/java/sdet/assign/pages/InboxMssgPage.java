package sdet.assign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdet.assign.base.TestBase;

public class InboxMssgPage extends TestBase {
	
	public InboxMssgPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement ackMssg;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement profileDD;
	
	@FindBy(id="logout_button")
	WebElement logOutBtn;
	
	public boolean ackMssgDisplayed() {
		return ackMssg.isDisplayed();	
	}
	
	public LoginPage doLogout() throws InterruptedException {
		profileDD.click();
		Thread.sleep(1000);
		logOutBtn.click();
		Thread.sleep(2000);
		return new LoginPage();
	}
}
