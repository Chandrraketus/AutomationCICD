package rahulshettyacasemy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RahulShettyAcademy.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyacademy.TestComponent.BaseTest;
import rahulShettyacademy.TestComponent.LandingPage;

public class stepDefinitionimpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		      
	}
	//Given Logged in with username rahulshetty@gmail.com and password IamKing@00
	
	@Given("^Logged in username(.+) and password(.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username,password);
		
	}
	
	@When("^I add product (.+) to cart$")
	
		public void i_add_product_to_cart(String productName) throws InterruptedException
		{
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
		
		
	}
	
	@When("^Checkout \\(.+\\) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout(); // Corrected variable name
		checkoutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{String} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String ConfirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase(string));
	}
	

}
