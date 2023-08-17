package Veereshcademy.Seleniumframework.test;

import java.io.IOException;
import java.time.Duration;
//import java.time.Duration;
import java.util.List;
//import java.util.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Veereshacademy.testComponent.BaseTest;
import Veereshcademy.Seleniumframework.CartPage;
import Veereshcademy.Seleniumframework.CheckOutPage;
import Veereshcademy.Seleniumframework.ConfirmationPage;
import Veereshcademy.Seleniumframework.LandingPage;
import Veereshcademy.Seleniumframework.OrderPage;
import Veereshcademy.Seleniumframework.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StandAlone2 extends BaseTest{
	String productName = "ZARA COAT 3";
	
	@Test
	public void Order() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//String array[]= {"ZARA COAT 3","ADIDAS ORIGINAL","IPHONE 13 PRO"};
		
		//System.setProperty("webdriver.edge.driver", "C:/Webdrivers/msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		String Country= "India";
		String Message = "THANKYOU FOR THE ORDER.";
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://rahulshettyacademy.com/client");
		
		landingpage.loginApplication("Veereshw.hgd@gmail.com", "Veeru@123");
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		productcatalogue.GoToCartPage();
		CartPage cartpage = new CartPage(driver);
		boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		cartpage.GoTOCheckOut();
		CheckOutPage checkout  = new CheckOutPage(driver);
		checkout.selectCountry(Country);
		checkout.orderSubmit();
		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		String ConfirmMessage =  confirmpage.getConfirmation();
		Assert.assertEquals(ConfirmMessage, Message);
		tearDown();
	}
		
		@Test(dependsOnMethods = {"Order"})
		public void OrderHistoryTest()
		{
			OrderPage orderpage = new OrderPage(driver);
			orderpage.GoToOdrerPages();
			Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
		}
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		//driver.findElement(By.id("userEmail")).sendKeys("Veereshw.hgd@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Veeru@123");
		
		//driver.findElement(By.id("login")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	//List<WebElement> list = driver.findElements(By.cssSelector(".mb-3"));
	
	//for(WebElement webelement : list)
	//{
		//System.out.println(webelement.findElement(By.cssSelector("b")).getText());
		//if(webelement.findElement(By.cssSelector("b")).getText().equals(productName));
		//System.out.println(webelement.findElement(By.cssSelector("b")).getText());
		//driver.findElement(By.xpath("(//button[contains(text(),'Add To Cart')])[1]")).click();
		//break;
	//}
	
  //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))); //ng-animating
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	//driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
	
	
	//{
	//List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	//Boolean match = CartProducts.stream().anyMatch(Cartproduct->Cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
	//Assert.assertTrue(match);
	//for(WebElement webelement : CartProducts)
	//{
		//System.out.println(webelement.getText());
		//if(webelement.getText().equals("ZARA COAT 3"))
		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		
	//driver.findElement(By.cssSelector(".totalRow button")).click();
		
	//}
	
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	
	//Actions a =new Actions(driver);
	//a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	
	//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	
	
	//String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	//Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	//WebElement prod = list.stream().filter(list1->list1.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	

	//}
//}
