package stepdefinations;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import java.util.List;

public class HomePageSteps{

	HomePage homePage;
	List<String> data;

	@When("User navigate to CricInfo homepage")
	public void user_navigate_to_cric_info_homepage() {
		homePage = new HomePage();
	}

	@When("user search for {string}")
	public void user_search_for(String searchValue) {
		homePage.enterValueInSearchBox(searchValue);
	}
	@Then("validate message {string}")
	public void validate_message(String searchValueOutput) {
		homePage.validateSearchText(searchValueOutput);
		BaseTest.tearDown();
	}

	@Then("validate homepage load successfully")
	public void validate_homepage_load_successfully() {

	}

	@Then("validate header section")
	public void validate_header_section(DataTable dataTable) {
		data = dataTable.asList(String.class);
		homePage.getTileNavigationBarLink();
		Assert.assertEquals(HomePage.tileNavigationBarLinkText,data,"validate header section failed");
	}

	@Then("validate body other sections")
	public void validate_body_other_section(DataTable dataTable) {
		data = dataTable.asList(String.class);
		homePage.getSectionText();
		Assert.assertEquals(HomePage.sectionTextExpected,data,"validate body other sections failed");
		BaseTest.tearDown();
	}
}
