package Veereshcademy.Seleniumframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class OrderPage extends AbstactComponent{
		
		WebDriver driver;
		
		public OrderPage(WebDriver driver)
		{
			//Intilization
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//WebElement eamil = driver.findElement(By.id("userEmail"));
		
		//Pagefactory
		
		@FindBy(css="tr td:nth-child(3)")
		List<WebElement> orderProducts;
		
		//@FindBy(css=".totalRow button")
		
		@FindBy(css="li[class='totalRow'] button[type='button']")
		WebElement CheckOut;
		
		By CheckoutAppear = By.cssSelector(".totalRow button");
		
		public boolean VerifyOrderDisplay(String productName)
		{
			boolean match = orderProducts.stream().anyMatch(orderProduct->orderProduct.getText().equalsIgnoreCase(productName));
			return match;
		}		
		

}
