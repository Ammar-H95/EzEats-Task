package tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.PaymentPage;

//IMPORTATN NOTE -- Login part is manually via FB account 

public class GuestOrderTest extends TestBase {

	private WebDriverWait wait;
	MenuPage menuPageObg;
	PaymentPage paymentPageObj;
	LoginPage loginPageObj;
	private final String[] productsList = { "Caesar The Pleaser", "Aloha Bowl" };
    private static final String EXPECTED_SUBTOTAL = "770";
	private int numberOfItems = 0;

	@BeforeMethod
	public void setUp() {
		paymentPageObj = new PaymentPage(driver);
		menuPageObg = new MenuPage(driver);
		loginPageObj = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	}

	@Test
	public void testGuestPlacingOrder() throws InterruptedException {
		
		loginPageObj.clickLoginBtn();
		
		loginPageObj.fbLoginBtn();
		
		performLoginManually();
		
		addProducts(menuPageObg.products);
		
		menuPageObg.clickViewOrder();
		
		paymentPageObj.clickConfirmOrder();
		
		paymentPageObj.refuseAddingAppetizer();
		
		Assert.assertEquals(paymentPageObj.subtotalAmount.getText(), EXPECTED_SUBTOTAL);
		
	}

	public void addProducts(List<WebElement> products) throws InterruptedException {

		for (int i = 0; i < menuPageObg.products.size(); i++) {

			String name = products.get(i).getText();

			List<String> addedProductsToCart = Arrays.asList(productsList);

			if (addedProductsToCart.contains(name)) {
				// we can't use break here as we are adding multiple items
				menuPageObg.products.get(i).click();
				menuPageObg.clickAddToCart();
				if (menuPageObg.needWaiterBtn.isDisplayed())
					numberOfItems++;
				else {
					menuPageObg.clickAddToCart();
				}

				if (numberOfItems == productsList.length) {
					break;
				}
			}
		}

	}

	private void performLoginManually() {
		// to assert we finished the login part and we are on the menu page
		wait.until(ExpectedConditions.visibilityOf(menuPageObg.needWaiterBtn));

		clickAction();
	}

	private void clickAction() {
		Actions actions = new Actions(driver);
		// Move to a specific location (offset: x = 80, y = 50) to be able to proceed
		// once a new account sign in
		// request waiter and view order is not clickable at the begining so this is a workaround
		actions.moveByOffset(80, 50).click().build().perform();
		actions.moveByOffset(60, 50).click().build().perform();
	}

}
