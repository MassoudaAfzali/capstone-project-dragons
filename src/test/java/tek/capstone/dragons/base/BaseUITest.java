package tek.capstone.dragons.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.dragons.utilities.CommonUtility;

public class BaseUITest extends CommonUtility{
	
	/*
	 * @Before hook
	 * @Before is a cucumber hook and we can setup the block of code under this 
	 * cucumber annotation under any class, but for the purpose of our test automation
	 * framework, we will setup the @Before hook in our BaseUITest class
	 * @After hook
	 * @After is a cucumber hook and we can setup the block of code under this cucumber
	 * annotation under any class, but for the purpose of our test automation
	 * framework, we will setup the @Before hook in our BaseUITest class
	 */
	
	/*
	 * Using Scenario class from Cucumber, we can pass this in our @After hook method
	 * parameter, so that just in case the test step fails and scenarios fails, 
	 * we can take a screenshot for that failed test step.
	 */
	
	@Before
	public void setupTests() {
		super.setupBrowser();
	}
	
	
	@After
	public void closeTests(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			scenario.attach(screenShot, "image/png", scenario.getName() + "scenario Failed");
		}
		super.quitBrowser();
	}
	
	

}


