package RahulShettyAcademy.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.AbstractComponent.BaseTest;

public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"}
	)

public void SubmitOrder(HashMap<String,String> input) throws IOExeception,InterruptedExeception{ 
	
	ProductCatalogue productCatalogue = LandingPage.LoginApplication(input.get("email"),input.get("password"));
	List<WebElement>products = productCatalogue.getProductList();
	CartPage cartPage = productCatalogue.goToCartPage();
	
	Boolean match = cartPage.VerifyProductDisplay(input.get(product));
	Assert.assertTrue(match);
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	String confirmMessage = confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmationMessage.equalsIgnoreCase("ThankYou For the order"));
	
	
	@Test(dependsOnMethods= {submitOrder})
	Run|Debug
	public void OrderHistoryTest()
	{	
		ProductCatalogue productCatalogue = LandingPage.loginApplication("anshika@gmail.com","IamKing@0000");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
		
		
	}
	@DataProvider
	public Object[][] getData()
//	HashMap<String,String> map = new Hashmap<string,String>();
//	map.put(("email", "anshika@gmail.com");
//	map.put("password", "IamKing000089")
//	map.put("product","ZARA COAT3");
	
	List<HashMap<String>>data = getJsonDataToMap();
	return new Object[][] {{map},{map1}};		 
	}
	
	public String getScreenshot(String testCaseName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png"
		
	}
	

}
