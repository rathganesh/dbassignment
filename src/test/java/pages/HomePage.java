package pages;

import java.time.Duration;
import java.util.List;
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
	
	private String[] tileNavigationBarLinkText = {"Live Scores","Series","Teams","News","Features","Videos","Stats"};
	private String[] sectionTextExpected = {"Match Coverage","Featured","Top Stories","Trending Players","Featured","In Depth","Writers","Key Series","Must Watch"};

	public HomePage() {
		setup();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		Assert.assertEquals(driver.getTitle(),"Today's Cricket Match | Cricket Update | Cricket News | ESPNcricinfo", "HomePage title not matching");
		PageFactory.initElements(driver, this);
		Assert.assertTrue(this.espnCricInfoLogo.isDisplayed(), "EspnCricInfoLogo not displayed");
	}
	
	public void validateTileNavigationBarLinkText() {
		  
		  for(int i=0; i<tileNavigationBarLink.size();i++) {
			  Assert.assertEquals(tileNavigationBarLink.get(i).getText(),
					  tileNavigationBarLinkText[i].toString(),tileNavigationBarLink.get(i).getText()+ " text not matched");
		  }
		 
	}

	public void validateSectionText() {

		for(int i=0; i<tileNavigationBarLink.size();i++) {
			Assert.assertEquals(tileNavigationBarLink.get(i).getText(),
					tileNavigationBarLinkText[i].toString(),tileNavigationBarLink.get(i).getText()+ " text not matched");
		}

	}
	

}
