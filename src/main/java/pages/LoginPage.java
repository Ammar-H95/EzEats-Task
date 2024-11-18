package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "p.MuiTypography-root.MuiTypography-body1")
	WebElement loginBtn;
	
	@FindBy (xpath = "(//button[@class='jss41'])[1]")
	WebElement googleLogin;
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	public void fbLoginBtn() {
		googleLogin.click();
	}

}
