package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import sdet.assign.base.TestBase;
import sdet.assign.pages.ComposeMessagePage;
import sdet.assign.pages.HomePage;
import sdet.assign.pages.InboxMssgPage;
import sdet.assign.pages.LoginPage;
import sdet.assign.pages.SignUpPage;
import sdet.assign.pages.SignUpPageAcknowledgementPage;



public class Assignment_1 extends TestBase{
	
	LoginPage loginPg;
	ComposeMessagePage composeMssgPg;
	HomePage homePg;
	InboxMssgPage inboxPg;
	SignUpPage signupPg;
	SignUpPageAcknowledgementPage signUpAckPg;
	String loginId,loginPwd;
	
	public Assignment_1() {
		
		initialize();
		loginPg=new LoginPage();
	}
	
	@Given("User has launched elearn url: {string}")
	public void user_has_launched_http_elearningm1_upskills_in(String url) {
		System.out.println("URL = "+url);
	}

	@When("User click on SignUp link")
	public void user_click_on_sign_up_link() {
		signupPg=loginPg.goToSignUp();
	}

	@Then("User should land on Registration page")
	public void user_should_land_on_registration_page() {
		Assert.assertEquals("My Organization - My education - Registration", signupPg.getTitle());
	}

	@When("User enter mandatory fields: {string},{string},{string},{string},{string},{string}")
	public void user_enter_mandatory_fields(String firstNm, String lastNm, String email, String userNm,
			String pwd, String cnfrmPwd) throws InterruptedException {
		//loginId=signupPg.enterMandatoryData4Registration(firstNm,lastNm,email,userNm,pwd,cnfrmPwd);
		signupPg.enterMandatoryData4Registration(firstNm,lastNm,email,userNm,pwd,cnfrmPwd);
		//loginPwd=pwd;
	}

	@When("Click on Register button on same page")
	public void click_on_register_button_on_same_page() {
		signUpAckPg=signupPg.clickRegister();
	}

	@Then("Message shown on next page: {string}")
	public void message_shown_on_next_page(String signUpAcknowledgement) {
		Assert.assertEquals(signUpAcknowledgement, signUpAckPg.getAckMssg());
		//signUpAckPg.clickProfileIcon();
	}

	@When("click on right top arrow")
	public void click_on_right_top_arrow() {
		signUpAckPg.clickProfileIcon();
	}

	@Then("user profile with entered {string} should be displayed")
	public void user_profile_with_entered_should_be_displayed(String emailId) throws InterruptedException {
		Assert.assertEquals(emailId, signUpAckPg.getEmailId());
	}
	
	@Then("User go to Home Page")
	public void gotoHomePage() {
		homePg=signUpAckPg.gotoHomePg();
	}

	@When("click on Compose link")
	public void click_on_compose_link() {
		composeMssgPg=homePg.goToCompose();
	}

	@Then("New_Message page should be displayed with title = {string}")
	public void new_message_page_should_be_displayed(String pgTitle) {
		Assert.assertEquals(pgTitle, composeMssgPg.getTitle());	
	}

	@When("user enter data for SenTo, Subject, messgae")
	public void user_enter_data_for_sen_to_subject_messgae() throws InterruptedException {
		composeMssgPg.createMessage();
		
	}

	@When("Click on Send Message button")
	public void click_on_send_message_button() throws InterruptedException {
		inboxPg=composeMssgPg.clickSendMssg();		
	}

	@Then("User should see acknowledgement message in Inbox Page")
	public void user_should_see_acknowledgement_message_in_inbox_page() {
		Assert.assertEquals(true,inboxPg.ackMssgDisplayed());
		
	}
	
	@When("User login and go to Homepage")
	public void login() {
		loginPg.doLogin(loginId,loginPwd);
	}
	
	@Then("Logout the browser")
	public void logout_the_browser() throws InterruptedException{
		//Thread.sleep(3000);
		loginPg=inboxPg.doLogout();
	}
	
	@And("Close the browser")
	public void close_the_browser(){
		driver.quit();
	}

}
