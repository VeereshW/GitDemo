package Veereshcademy.Seleniumframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class CartPage extends AbstactComponent{
		
		WebDriver driver;
		
		public CartPage(WebDriver driver)
		{
			//Intilization
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//WebElement eamil = driver.findElement(By.id("userEmail"));
		
		//Pagefactory
		
		@FindBy(css=".cartSection h3")
		List<WebElement> CartProducts;
		
		//@FindBy(css=".totalRow button")
		
		@FindBy(css="li[class='totalRow'] button[type='button']")
		WebElement CheckOut;
		
		By CheckoutAppear = By.cssSelector(".totalRow button");
		
		public boolean VerifyProductDisplay(String productName)
		{
			boolean match = CartProducts.stream().anyMatch(Cartproduct->Cartproduct.getText().equalsIgnoreCase(productName));
			return match;
		}
		
		public void GoTOCheckOut() throws InterruptedException {
			
			waitforElementToClickable(CheckoutAppear);
			CheckOut.click();
		}
		

}
