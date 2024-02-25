package RahulShettyAcademy.pageobjects;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import sun.security.util.Password;

public class ProductCatalogue {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement>products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css="#toast-container")
	WebElement toastMessage;
	
	By productsBy =By.cssSelector(".mb-3");
	By addToCard = By.cssSelector(".card-body button:last-of-type");

	private Collection<WebElement> getProductList;
	
	public List<WebElement>getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}

	private void waitForElementToAppear(By productsBy2) {
		// TODO Auto-generated method stub
		
	}
	
	public WebElement getProductByName(String producttName)
	{
	    WebElement prod = getProductList.stream().filter(
		product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCard ).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	
		
	}

	private void waitForElementToDisappear(WebElement spinner2) {
		// TODO Auto-generated method stub
		
	}

	public CartPage goToCartPage() {
		// TODO Auto-generated method stub
		return null;
	}
	}

//	@FindBy(id="userEmail")
//	WebElement userEmail;
//	
//	@FindBy(id="userPassword")
//	WebElement passwordEle;
//	
//	@FindBy(id="login")
//	WebElement subbmit;
//	
//	
//	public void LoginApplication(String email,String password)
//	{
//		userEmail.sendKeys(email);

//		passwordEle.sendKeys(password);
//		subbmit.click();
//	}
//	public void goTO() {
//		driver.get("https://rahulshettyacademy.com/client");
//		
//	}
//
//}
