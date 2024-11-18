package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Confirm these items')]")
	WebElement confirmOrderBtn;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	WebElement appetizersRefuseBtn;
	@FindBy (xpath = "//p[@class='MuiTypography-root jss1287 MuiTypography-body1']")
	public WebElement subtotalAmount;

	public void clickConfirmOrder() {
		confirmOrderBtn.click();
	}

	public void refuseAddingAppetizer() {
		appetizersRefuseBtn.click();
	}
}
