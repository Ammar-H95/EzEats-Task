package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase {

	public MenuPage(WebDriver driver) {
		super(driver);
	}
    @FindBy (css = ".MuiBox-root.jss206")
    public WebElement needWaiterBtn;
    
	@FindBy(tagName = "h6")
	public List<WebElement> products;

	// will click the 1st item
	@FindBy(xpath = "//span[contains(text(),'Add 1 to cart')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//span[contains(text(),'View pending order')]")
	WebElement viewOrderBtn;


	public void clickAddToCart() {
		addToCartBtn.click();
	}
	public void clickViewOrder() {
		viewOrderBtn.click();
	}
	public void clickNeedWaiter() {
		needWaiterBtn.click();
	}
}
