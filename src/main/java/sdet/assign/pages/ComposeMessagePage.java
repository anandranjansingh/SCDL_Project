package sdet.assign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sdet.assign.base.TestBase;

public class ComposeMessagePage extends TestBase{
	public ComposeMessagePage(){
		PageFactory.initElements(driver,this);		
	}
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement sendTo;
	
	@FindBy(xpath="//*[@class='select2-dropdown select2-dropdown--below']//li[3]")
	WebElement ddItem;	
	
	@FindBy(id="compose_message_title")
	WebElement subject;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement mssgFrame;
	
	@FindBy(xpath="html/body")
	WebElement iFrameMssg;
	
	
	@FindBy(id="compose_message_compose")
	WebElement sendMssgBtn;
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void createMessage() throws InterruptedException {
		sendTo.sendKeys("Ani");
		Thread.sleep(1000);
		ddItem.click();
		subject.sendKeys("=====TEST COMPOSE MESSAGE=====");
		
		driver.switchTo().frame(mssgFrame);
		Thread.sleep(1000);
		iFrameMssg.sendKeys("This is message body to enter message");
		
		driver.switchTo().defaultContent();
	}
	
	public InboxMssgPage clickSendMssg() throws InterruptedException {
		Thread.sleep(1000);
		sendMssgBtn.click();
		return new InboxMssgPage();
	}

}
