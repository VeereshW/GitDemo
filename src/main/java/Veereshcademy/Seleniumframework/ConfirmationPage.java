package Veereshcademy.Seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Veereshacademy.abstarct.AbstactComponent;

public class ConfirmationPage extends AbstactComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		//Intilization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".hero-primary")
	WebElement MessageDisplay;
	
	public String getConfirmation()
	{
		String ConfirmMessage = MessageDisplay.getText();
		return ConfirmMessage;
	}

	
	
	

}
