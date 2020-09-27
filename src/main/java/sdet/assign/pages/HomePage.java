package sdet.assign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdet.assign.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Compose']")
	WebElement composeMail;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement profileDD;
	
	
	@FindBy(id="logout_button")
	WebElement logOutBtn;
	
	public ComposeMessagePage goToCompose() {
		composeMail.click();
		return new ComposeMessagePage();
	}
	
	public LoginPage doLogout() throws InterruptedException {
		profileDD.click();	
		Thread.sleep(1000);
		logOutBtn.click();
		Thread.sleep(2000);
		return new LoginPage();
	}	
}
