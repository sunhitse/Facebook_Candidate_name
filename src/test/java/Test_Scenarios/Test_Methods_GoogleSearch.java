package Test_Scenarios;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.GoogleSearchPage;
import Objects.FacebookPage;

public class Test_Methods_GoogleSearch {

	WebDriver driver;
	GoogleSearchPage GoogleSearchPage;

	FacebookPage FacebookPage;

	@BeforeTest
	public void beforetest() {
		// WebDriverManager.chmedriver().setup();
	 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void SearchOperation() throws InterruptedException {
		GoogleSearchPage page = new GoogleSearchPage(driver);
		// page.click();
		page.searchgoogle("facebook");
		

		// Thread.sleep(5000);
	}

	@Test(priority=1)
	public void VerifyandAccessFacebook() throws InterruptedException {
		GoogleSearchPage page = new GoogleSearchPage(driver);

		page.ClickFacebook();
	}

	@Test(priority=2)
	public void VerifyLoginfunctionality() throws InterruptedException {
		FacebookPage page = new FacebookPage(driver);

		Thread.sleep(2000);
		page.EnterUsername();
		page.EnterPassword();
		//Thread.sleep(1000);
		page.VerifyLogin();
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
