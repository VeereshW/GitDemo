package Veereshcademy.Seleniumframework.test;

import java.time.Duration;
//import java.time.Duration;
import java.util.List;
//import java.util.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class StandAloneTest {

	public static <WebElements> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//String array[]= {"ZARA COAT 3","ADIDAS ORIGINAL","IPHONE 13 PRO"};
		
		System.setProperty("webdriver.edge.driver", "C:/Webdrivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--remote-allow-origins=*");
		//ChromeDriver driver = new ChromeDriver(chromeOptions);
		// EdgeDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("Veereshw.hgd@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Veeru@123");
		
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	List<WebElement> list = driver.findElements(By.className(".mb-3"));
	
	for(WebElement webelement : list)
	{
		//System.out.println(webelement.findElement(By.cssSelector("b")).getText());
		if(webelement.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"));
		//System.out.println(webelement.findElement(By.cssSelector("b")).getText());
		//driver.findElement(By.xpath("(//button[contains(text(),'Add To Cart')])[1]")).click();
		
	}
	
	
	//WebElement prod = list.stream().filter(list1->list1.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-contaoner"))); //ng-animating
	
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	
	driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']"));
	

	}
}
