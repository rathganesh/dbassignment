package stepdefinations;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;

public class HomePageSteps{

	HomePage homePage;

	@When("User navigate to CricInfo homepage")
	public void user_navigate_to_cric_info_homepage() {
		homePage = new HomePage();
	}
	@Then("validate homepage load successfully")
	public void validate_homepage_load_successfully() {
		homePage.validateTileNavigationBarLinkText();
		homePage.validateTileNavigationBarLinkText();
		BaseTest.tearDown();
	}
}
