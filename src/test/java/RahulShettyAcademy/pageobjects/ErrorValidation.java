package RahulShettyAcademy.pageobjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.AbstractComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest {
	
	@Test(groups = {"ErrorHandlinng"})
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("rojauygf@wu.com","imkh78987");	
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage()));"

	}
	
	@Test
	
	
	
	public void ProductErrorValidation() {

	
	String productName = "ZARA COAT 3";
	LandingPage landingPage =  launchApplication();  
	ProductCatalogue productCatalogue = landingPage.LoginApplication("Sharma@wu.com", "India");
	
	List<WebElement>products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage = productCatalogue.goToCartPage();
	
	Boolean match = cartPage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("India");
	ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	String confirmMessage = confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	

}
}


//ronit@wu.com", "India@12"
