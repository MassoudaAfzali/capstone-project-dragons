package tek.capstone.dragons.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	//@findBy == findElement/findElements
    @FindBy(id="signinLink")
	public WebElement signIn;
    
 // we validate that this account is present after we sign in

 	@FindBy(id="accountLink")
	public WebElement accountBtn;
	
	@FindBy(id="orderLink")
	public WebElement orderBtn;
	
	
	//Home page locators
	@FindBy(id="hamburgerBtn")
	public WebElement AllOptionBtn;
	@FindBy(xpath = "//div[@data-id='1']")
	public WebElement elictronics;
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div[2]")
	public WebElement computers;
	@FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div[3]")
	public WebElement homeSmart;
	@FindBy(xpath = "//div[@data-id='4']")
	public WebElement sports;
	@FindBy(xpath = "//div[@data-id='5']")
	public WebElement automative;
	
	
	
	//HomeAll
	@FindBy(xpath = "//span[text()='TV & Video']")
	public WebElement TVAndVideo;
	@FindBy(xpath = "//span[text()='Video Games']")
	public WebElement VideoGames;
	@FindBy(xpath = "//span[text()='Accessories']")
	public WebElement Accessories;
	@FindBy(xpath = "//span[text()='Networking']")
	public WebElement Networking;
	@FindBy(xpath = "//span[text()='Smart Home Lightning']")
	public WebElement SmartHomeLightning;
	@FindBy(xpath = "//span[text()='Plugs and Outlets']")
	public WebElement PlugsandOutlets;
	@FindBy(xpath = "//span[text()='Athletic Clothing']")
	public WebElement AthleticClothing;
	@FindBy(xpath = "//span[text()='Exercise & Fitness']")
	public WebElement ExerciseFitness;
	@FindBy(xpath = "//span[text()='Automative Parts & Accessories']")
	public WebElement AutomativePartsAccessories;
	@FindBy(xpath = "//span[text()='MotorCycle & Powersports']")
	public WebElement MotorCyclePowersports;
	@FindBy(css = "div.sidebar__content")
	public WebElement Alltrue;
	
	
	// Add to Cart
	
	
		@FindBy(id = "search")
		public WebElement allDepartmentdorpDown;
		@FindBy(id = "searchInput")
		public WebElement searchInput;
		@FindBy(id = "searchBtn")
		public WebElement searchBtn;
		@FindBy (css = "div.products__layout")
		public WebElement addItem;
		@FindBy(css = "select.product__select")
		public WebElement quantity;
		@FindBy(id = "addToCartBtn")
		public WebElement addToCartBtn;
		@FindBy(id = "cartQuantity")
		public WebElement cartQuantity;
		@FindBy(id = "cartBtn")
		public WebElement cartBtn;
		@FindBy(id = "proceedBtn")
		public WebElement proceedBtn;
		@FindBy(id = "addAddressBtn")
		public WebElement addAddressBtnCart;
		@FindBy(id = "addPaymentBtn")
		public WebElement addPaymentBtnCart;
		@FindBy(id = "placeOrderBtn")
		public WebElement placeOrderBtn;
		@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div/div[1]/p")
		public WebElement thankYouMessage;
	
	
	
	
	

}
