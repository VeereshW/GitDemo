package Veereshcademy.Seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class CheckOutPage extends AbstactComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		//Intilization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryName;
	
	@FindBy(css="(//button[@type='button'])[2]\")")
	WebElement countrySelect;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement submitOrder;
	
	public void selectCountry(String country)
	{
	Actions a =new Actions(driver);
	a.sendKeys(countryName, country).build().perform();
	countrySelect.click();
	}
	
	public void orderSubmit()
	{
		submitOrder.click();
	}

	
	
}
