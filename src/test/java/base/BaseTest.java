package base;

import java.io.IOException;
import java.time.Duration;

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

//	@Before
	public void setup() {

		try {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}


	}
	
//	@After
	public static void tearDown() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.close();
		driver.quit();
	}
}
