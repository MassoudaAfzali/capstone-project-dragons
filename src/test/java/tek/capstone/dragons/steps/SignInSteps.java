package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
	String expectedTitle = "React App";
	String actualTitle = getTitle();
	Assert.assertEquals(expectedTitle, actualTitle);
	logger.info(actualTitle +" is equal to "+ expectedTitle);
	}
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signIn);
		logger.info("user clicked on Sign In option");

	    
	}
	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.signInPage().emailField, email);
		sendText(factory.signInPage().passwordField,password);
		logger.info("user entered the email" +email + "and password" + password);
	  
	}
	
	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().loginButton);
		logger.info("user clicked on Login button");
		
	}

	
	@Then("User should be logged in into Account")
	public void UserShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(isElementDisplayed(factory.homePage().accountBtn));
// we have to write assertionton to make sure that element is present 
	logger.info("user logged in to acount");	
	slowDown();
		
	}
	
	
	// Signup Steps
	@When("User click on Create New Account button")
	public void User_Click_On_Create_NewAccount_Btn() {
		click(factory.signInPage().createNewAccountBtn);
		logger.info(" user clicked on create new Account Button");
	}
	
	@And("User fill the signUp information with below data")
	public void user_Fill_The_SignUp_Infromation_With_Below_Data(DataTable datatable) {
		List<Map<String, String>> signUpData = datatable.asMaps(String.class,String.class);
		sendText(factory.signInPage().nameInput,signUpData.get(0).get("name"));
		sendText(factory.signInPage().emailInput,signUpData.get(0).get("email"));
		sendText(factory.signInPage().passwordInput,signUpData.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInput,signUpData.get(0).get("confirmPassword"));
		logger.info("user entered username, email, password, confirmpassword");
		slowDown();
	}
	

	@When("User click on SignUp button")
	public void user_click_on_signUp_button() {
	click(factory.signInPage().signupBtn);
	logger.info("user click on signUp button");
	slowDown();	
	}
	
	
	@Then("User should be logged into account page")
	public void user_should_be_logged_into_account_page() {
		//eWait(10,factory.signInPage().profileImage);
		Assert.assertTrue(isElementDisplayed(factory.signInPage().profileImage));
		logger.info("user should be in Account Page and profileImageIcon, AccountBtnOption, and orderBtnoption should be visiable");
		
	}



}



