package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class ReatilAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void user_click_on_account_option() {
		click(factory.accountPage().accountLink);
		logger.info("User clicked on Account option");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(factory.accountPage().nameInputUpdate);
		sendText(factory.accountPage().nameInputUpdate, name);
		clearTextUsingSendKeys(factory.accountPage().phoneNumberUpdate);
		sendText(factory.accountPage().phoneNumberUpdate, phoneNumber);
		logger.info("User update name: " + name + "and phone number: " + phoneNumber);

	}

	@When("User click on Update button")
	public void user_click_on_Update_button() {
		click(factory.accountPage().personalUpdateBtn);
		logger.info("User clicked on Update button");

	}

	@Then("user profile information should be updated")
	public void user_Profile_Information_Should_Be_Updated() {
		String expectedUserName = getText(factory.accountPage().infoUsernameUpdate);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().infoUsernameUpdate));
		logger.info("User has updated user name to " + expectedUserName);

	}

	// @AccountPassword
	@When("User enter below information")
	public void user_enter_below_information(DataTable dataTable) {
		List<Map<String, String>> passwordList = dataTable.asMaps(String.class, String.class);
		waitTillPresence(factory.accountPage().previousPasswordInput);
		sendText(factory.accountPage().previousPasswordInput, passwordList.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput, passwordList.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordInput, passwordList.get(0).get("confirmPassword"));
		logger.info("User Changed the Password");
	}

	@When("User click on Change Password button")
	public void user_Click_On_Change_Password_Button() {
		click(factory.accountPage().changePasswordtBtn);
		logger.info("User clicked on changePassword Button");
		slowDown();
	}

	@Then("a message should be displayed {string}")
	public void aMessage_Should_Be_Displayed_Password_Updated_Successfully(String password) {
		String expectedText = password;

		String actualText = getText(factory.accountPage().passwordChangedPop);
		Assert.assertEquals(expectedText, actualText);
		logger.info("Password Successfuly changed");

	}

	// @AcountPayment
	@When("User click on Add a payment method link")
	public void user_Click_On_Add_A_Payment_Method_Link() {
		click(factory.accountPage().paymentLinkClick);
		logger.info("User clicked on Add a payment method link");
	}

	@When("User fill Debit or credit card information")
	public void user_Fill_Debit_Or_Credit_Card_Information(DataTable dataTable) {
		List<Map<String, String>> creditCardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, creditCardInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, creditCardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput, creditCardInfo.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationOnMonthInput, creditCardInfo.get(0).get("expirationMonth"));
		sendText(factory.accountPage().securityCodeInput, creditCardInfo.get(0).get("securityCode"));
		logger.info("User filled Credit Card Information");
	}

	@When("User click on Add your card button")
	public void user_Click_On_Add_YourCardButton() {
		click(factory.accountPage().paymentSubmitBtn);
		logger.info("User clicked on payment submit Btn");
		slowDown();
	}

	@Then("a message should be displayed‘Payment Method added sucessfully’")
	public void a_message_should_be_displayed_payment_method_added_successfully() {
		// eWait(10, factory.accountPage().PaymentMethodupdatedSuccessfully);
		waitTillPresence(factory.accountPage().PaymentMethodAddedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().PaymentMethodAddedSuccessfully));
		logger.info("Payment Method added successfully");
		slowDown();

	}

	// @AccountPaymentUpdate
	@When("User click on Edit option of card section")
	public void user_Click_On_Edit_OptionOf_Card_Section() {
		click(factory.accountPage().clickOnMasterCard);
		click(factory.accountPage().cardEditBtn);
		logger.info("User clicked on Edit option");
		slowDown();
	}

	@When("user edit information with below data")
	public void user_Edit_Information_With_Below_Data(io.cucumber.datatable.DataTable dataTable) {
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);
		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		clearTextUsingSendKeys(factory.accountPage().securityCodeInput);

		List<Map<String, String>> updateCardInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, updateCardInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInput, updateCardInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationYearInput, updateCardInfo.get(0).get("expirationYear"));
		selectByVisibleText(factory.accountPage().expirationOnMonthInput, updateCardInfo.get(0).get("expirationMonth"));

		sendText(factory.accountPage().securityCodeInput, updateCardInfo.get(0).get("securityCode"));
		logger.info("User updated the Cridet Card information");
		slowDown();

	}

	@When("user click on Update Your Card button")
	public void user_Click_On_Update_Your_Card_Button() {
		click(factory.accountPage().paymentSubmitBtn);
		logger.info("User clicked on paymentSubmitBtn");
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessage_Should_Be_Displayed_Payment_Method_Updated_Successfully() {
		// eWait(10, factory.accountPage().PaymentMethodupdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().PaymentMethodupdatedSuccessfully));
		logger.info("Payment card has been updated successfully");
	}

	// @Acountpaymentremove
	@Then("User click on remove option of card section")
	public void paymentDetailsShouldBeRemoved() {
		click(factory.accountPage().clickOnMasterCard);
		click(factory.accountPage().removeBtn);
		logger.info("User clicked on remov option button");

	}

	@Then("payment details should be removed")
	public void payment_Details_Should_Be_Removed() {
		if (isElementDisplayed(factory.accountPage().clickOnMasterCard)) {
			logger.info("Card remove successfully");
		}
	}
	// Address

	@When("User click on Add address option")
	public void user_Click_On_Add_Address_Option() {
		click(factory.accountPage().addAddressClick);
		logger.info("User click on Add address option");
	}

	@When("user fill new address form with below information")
	public void user_Fill_New_Address_Form_With_Below_Information(DataTable dataTable) {
		List<Map<String, String>> AddressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, AddressInfo.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().addressFullNameInput);
		sendText(factory.accountPage().addressFullNameInput, AddressInfo.get(0).get("fullName"));
		slowDown();

		clearTextUsingSendKeys(factory.accountPage().phoneNumberInputAddress);
		sendText(factory.accountPage().phoneNumberInputAddress, AddressInfo.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streertInputAddress);
		sendText(factory.accountPage().streertInputAddress, AddressInfo.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().apartmentInputAddress);
		sendText(factory.accountPage().apartmentInputAddress, AddressInfo.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().cityInputAddress);
		sendText(factory.accountPage().cityInputAddress, AddressInfo.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateDropDownAddress, AddressInfo.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().zipCodeInputAddress);
		sendText(factory.accountPage().zipCodeInputAddress, AddressInfo.get(0).get("zipCode"));

		logger.info("User filled out Address Information");

	}

	@When("User click Add Your Address button")
	public void user_Click_Add_Your_Address_Button() {
		click(factory.accountPage().addressSubmissionBtn);
		logger.info("User clicked on address submission button");
		slowDown();
	}

	@Then("a message should be displayed ‘Address Added Successfully’")
	public void aMessage_Should_Be_Displayed_Address_Added_Successfully() {
		waitTillPresence(factory.accountPage().AddressAddedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().AddressAddedSuccessfully));
		logger.info("Address Added successfully Massege shown");
	}

	// AddressEdit

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressBtn);
		logger.info("User clicked on update Address");

	}

	@When("user fill new address form  with below information")
	public void userfillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> upDateAdd = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, upDateAdd.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().addressFullNameInput);
		sendText(factory.accountPage().addressFullNameInput, upDateAdd.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumberInputAddress);
		sendText(factory.accountPage().phoneNumberInputAddress, upDateAdd.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().streertInputAddress);
		sendText(factory.accountPage().streertInputAddress, upDateAdd.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().apartmentInputAddress);
		sendText(factory.accountPage().apartmentInputAddress, upDateAdd.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().cityInputAddress);
		sendText(factory.accountPage().cityInputAddress, upDateAdd.get(0).get("city"));
		selectByVisibleText(factory.accountPage().stateDropDownAddress, upDateAdd.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().stateDropDownAddress);
		sendText(factory.accountPage().zipCodeInputAddress, upDateAdd.get(0).get("zipCode"));
		logger.info("User filled out the Address informaition ");

	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().UpdateAddressBtn);
		logger.info("user clicked on updated address button");

	}

	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
		waitTillPresence(factory.accountPage().AddressUpdatedSuccessfully);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().AddressUpdatedSuccessfully));
		logger.info("user Updated successfully");

	}

	// removed

	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().RemoveAddress);
		logger.info("user clicked on removed the Address button");

	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {

		if (!isElementDisplayed(factory.accountPage().addressBar))
			;

		logger.info("Address removed Successfully");
	}
}
