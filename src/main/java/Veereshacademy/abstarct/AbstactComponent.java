package Veereshacademy.abstarct;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstactComponent {
	WebDriver driver;
	
	public AbstactComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement Cart;
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement OrderHeader;

	public void waitforElementToAppear(By findBy) 
	{
		
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforElementToClickable(By findBy) 
	{
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void GoToCartPage()
	{
		Cart.click();
	}
	
	public void GoToOdrerPages()
	{
		OrderHeader.click();
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
