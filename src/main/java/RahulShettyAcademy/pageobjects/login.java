package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class login {

	

	private static WebElement dropdown;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.edge.driver", "D:\\");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
        Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Chandraketu");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sharma");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("Sharma123ronit@gmail.com");
		driver.findElement(By.xpath("//input[@id='userMobile']")).sendKeys("8225938262");
        driver.findElement(By.xpath("//option[contains(text(),'Engineer')]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-register[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[3]/div[2]/label[2]/span[1]")).click();
        driver.findElement(By.id("userPassword")).sendKeys("Ronit123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Ronit123");
        
        driver.findElement(By.cssSelector("div[class='banner'] section:nth-child(1)")).isSelected();
		
		
	}

}
