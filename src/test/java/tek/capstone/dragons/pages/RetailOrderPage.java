package tek.capstone.dragons.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Order cancelling

	@FindBy(id = "orderLink")
	public WebElement orderLinkClick;
	@FindBy(css = "div.order__status-arriving")
	public WebElement firstOrder;
	@FindBy(id = "cancelBtn")
	public WebElement cancelBtn;
	@FindBy(id = "reasonInput")
	public WebElement reasonInput;
	@FindBy(id = "orderSubmitBtn")
	public WebElement orderSubmitBtn;
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement cancelationMessage;

	// Return Order
	@FindBy(xpath = "(//p[@class='order__header-btn'])[2]")
	public WebElement elementclick;
	@FindBy(xpath = "//button[@id=\"returnBtn\"]")
	public WebElement returnItemsBtn;
	@FindBy(id = "reasonInput")
	public WebElement reasonInputReturn;
	@FindBy(id = "dropOffInput")
	public WebElement dropOffInput;
	@FindBy(id = "orderSubmitBtn")
	public WebElement orderSubmitReturnBtn;
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement returnOrderMessage;

//	reviewing Order

	@FindBy(id = "reviewBtn")
	public WebElement reviewBtn;
	@FindBy(id = "headlineInput")
	public WebElement headlineInput;
	@FindBy(id = "descriptionInput")
	public WebElement descriptionInput;
	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBtn;
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewSuccessMassage;

	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrder;
	
	@FindBy(xpath = "//div[@class='order']//descendant::button[@id='cancelBtn']")
	public List<WebElement> cancelBttn;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/div/div/div/div/div[2]/div/p[2]")
	public WebElement showDetails;

}