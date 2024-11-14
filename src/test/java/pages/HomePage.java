package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class HomePage{
	@FindBy( xpath = "//img[@alt='ESPNcricinfo']")
	private WebElement espnCricInfoLogo;
	
	@FindBy(xpath = "//img[@alt='ESPNcricinfo']/ancestor::div[2]//a[text()]")
	private List<WebElement> tileNavigationBarLink;
	
	private String[] tileNavigationBarLinkText = {"Live Scores","Series","Teams","News","Features","Videos","Stats"};
	
	
	public HomePage() {
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(BaseTest.driver.getTitle(),"Today's Cricket Match | Cricket Update | Cricket News | ESPNcricinfo", "HomePage title not matching");
		PageFactory.initElements(BaseTest.driver, this);
		Assert.assertTrue(this.espnCricInfoLogo.isDisplayed(), "EspnCricInfoLogo not displayed");
	}
	
	public void validateTileNavigationBarLinkText() {
		
		/*
		 * int i = 0; for (WebElement wb : this.tileNavigationBarLink) {
		 * Assert.assertEquals(wb.getText(),
		 * tileNavigationBarLinkText[i].toString(),wb.getText()+ " text not matched");
		 * i++; }
		 */
		  
		  for(int i=0; i<tileNavigationBarLink.size();i++) {
			  Assert.assertEquals(tileNavigationBarLink.get(i).getText(),
					  tileNavigationBarLinkText[i].toString(),tileNavigationBarLink.get(i).getText()+ " text not matched");
		  }
		 
	}
	

}
