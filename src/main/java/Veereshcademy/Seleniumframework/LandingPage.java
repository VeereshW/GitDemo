package Veereshcademy.Seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class LandingPage extends AbstactComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		//Intilization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement eamil = driver.findElement(By.id("userEmail"));
	
	//Pagefactory
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;

	public LandingPage loginApplication(String userEmail , String Passworduser)
	
	{
		email.sendKeys(userEmail);
		Password.sendKeys(Passworduser);
		Submit.click();
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
