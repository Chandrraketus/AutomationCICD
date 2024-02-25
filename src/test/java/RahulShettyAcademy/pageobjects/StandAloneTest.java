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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);		
		driver.findElement(By.id("userEmail")).sendKeys("Sharma123ronit@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ronit123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(
		product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
		
		Thread.sleep(5000);
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean matcn = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(matcn);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector("app-order.ng-star-inserted:nth-child(2) section.content:nth-child(2) div.container-fluid div.row div.col-md-7 div.container div.payment div.payment__info div.payment__shipping div.details__user div.user__name.mt-5 div.user__address:nth-child(3) div.form-group:nth-child(2) section.ta-results.list-group.ng-star-inserted > button.ta-item.list-group-item.ng-star-inserted:nth-child(3)")).click();
		driver.findElement(By.cssSelector("app-order.ng-star-inserted:nth-child(2) section.content:nth-child(2) div.container-fluid div.row div.col-md-7 div.container div.payment div.payment__info div.payment__shipping div.details__user div.user__name.mt-5 div.actions:nth-child(4) > a.btnn.action__submit.ng-star-inserted")).click();
		String ConfirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
//		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
//		
		
		
		////button[@routerlink='/dashboard/cart']"))
		////button[@routerlink='/dashboard/cart']
		
		
		

	}

}
