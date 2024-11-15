package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class HomePage extends BaseTest{
	@FindBy( xpath = "//img[@alt='ESPNcricinfo']")
	private WebElement espnCricInfoLogo;
	
	@FindBy(xpath = "//img[@alt='ESPNcricinfo']/ancestor::div[2]//a[text()]")
	private List<WebElement> tileNavigationBarLink;

	@FindBy(xpath = "//h2[text()]")
	private List<WebElement> sectionText;

	@FindBy(xpath = "//i[@class='icon-search-outlined ds-text-icon-inverse ci-nav-item ci-nav-hover']")
	private WebElement searchIcon;

	@FindBy(xpath = "//input[@placeholder='Search Players, Teams or Series']")
	private WebElement searchBoxInput;

	@FindBy(xpath = "//p[@class='searched-for']")
	private WebElement searchResultText;

	public static List<String> tileNavigationBarLinkText = new ArrayList<>();
	public static List<String> sectionTextExpected = new ArrayList<>();

	public HomePage() {
		setup();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		Assert.assertEquals(driver.getTitle(),"Today's Cricket Match | Cricket Update | Cricket News | ESPNcricinfo", "HomePage title not matching");
		PageFactory.initElements(driver, this);
		Assert.assertTrue(this.espnCricInfoLogo.isDisplayed(), "EspnCricInfoLogo not displayed");
	}

	public List<String> getSectionText(){
		for (WebElement value : sectionText){
			sectionTextExpected.add(value.getText());
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		}
		return sectionTextExpected;
	}

	public List<String> getTileNavigationBarLink(){
		for (WebElement value : tileNavigationBarLink){
			tileNavigationBarLinkText.add(value.getText());
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		}
		return tileNavigationBarLinkText;
	}

	public void enterValueInSearchBox(String enterSearchValue){
		this.searchIcon.click();
		searchBoxInput.sendKeys(enterSearchValue+ Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}

	public void validateSearchText(String searchTextValue){
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		Assert.assertTrue(this.searchResultText.getText().contains(searchTextValue),"Search text value not matched");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}


}
