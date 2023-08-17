package Veereshcademy.Seleniumframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class ProductCatalogue extends AbstactComponent{
	

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> list = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> list;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;

	By listby = By.cssSelector(".mb-3");
	By Cartby = By.cssSelector(".card-body button:last-of-type");
	By toastAppear = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitforElementToAppear(listby);
		return list;
	}
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod = list.stream().filter(list1->list1.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
		
	public void addProductToCart(String productName) 
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(Cartby).click();
		waitforElementToAppear(toastAppear);
		waitForElementToDisappear(spinner);
	}
   
}
