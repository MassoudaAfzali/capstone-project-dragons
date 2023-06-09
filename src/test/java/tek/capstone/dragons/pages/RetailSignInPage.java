package tek.capstone.dragons.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailSignInPage extends BaseSetup{
	
	public RetailSignInPage () {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(id="signinLink")
	public WebElement signBtn;

	@FindBy(id="email")
	public WebElement emailField;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	public WebElement loginButton;
	
	//SignUp Locators
	@FindBy(id="newAccountBtn")
	public WebElement createNewAccountBtn;
	
	@FindBy(id="nameInput")
	public WebElement nameInput;
	
	@FindBy(id="emailInput")
	public WebElement emailInput;
	
	@FindBy(id="passwordInput")
	public WebElement passwordInput;
	
	@FindBy(id="confirmPasswordInput")
	public WebElement confirmPasswordInput;
	
	@FindBy(id="signupBtn")
	public WebElement signupBtn;
	
	@FindBy(id="profileImage")
	public WebElement profileImage;
	
}
	