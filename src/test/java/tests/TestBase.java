package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	WebDriver driver;
	String baseURL = "https://ezeats.app/NpF9ZURykX-9999";
 
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(baseURL);
  }
 
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
