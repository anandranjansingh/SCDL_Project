@All
Feature: Automate Signup and SendMessage fucntionality

@Signup
Scenario Outline: Register a user new user at elearningm1 and send Message from his/her account
Given User has launched elearn url: "http://elearningm1.upskills.in/"
When User click on SignUp link
Then User should land on Registration page
When User enter mandatory fields: "<FirstName>","<LastName>","<Email>","<Username>","<Password>","<ConfirmPwd>"
And Click on Register button on same page
Then Message shown on next page: "Dear <FirstName> <LastName>,Your personal settings have been registered."
When click on right top arrow
Then user profile with entered "<Email>" should be displayed
Then User go to Home Page
When click on Compose link
Then New_Message page should be displayed with title = "My Organization - My education - Compose message"
When user enter data for SenTo, Subject, messgae
And Click on Send Message button
Then User should see acknowledgement message in Inbox Page
Then Logout the browser
And Close the browser


Examples: 
|FirstName|LastName|Email								|Username|Password |ConfirmPwd|
|Ani	  	|Shah    |anil.shah@gmail.com |ani.shah|ani.shah1|ani.shah1 |













#@SendMessage
#Scenario: Compose and Send message along with verification of acknowledgement
#When User login and go to Homepage
#When click on Compose link
#Then New_Message page should be displayed
#When user enter data for SenTo, Subject, messgae
#And Click on Send Message button
#Then User should see acknowledgement messgae in Inbox Page
