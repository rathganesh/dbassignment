package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadPropertyFile;

public class BaseTest {
	
	public static WebDriver driver;
	ChromeOptions options;
	public ReadPropertyFile readPropertyFile = new ReadPropertyFile();

	@Before
	public void setup() throws IOException {
		System.out.println("Before");
		if (readPropertyFile.getPropertiesFileValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(readPropertyFile.getPropertiesFileValue("testurl"));

		}else
		{
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(readPropertyFile.getPropertiesFileValue("testurl"));
		}

	}
	
	@After
	public void tearDown() throws InterruptedException {
		driver.close();
		driver.quit();
		Thread.sleep(2000);
	}
}
