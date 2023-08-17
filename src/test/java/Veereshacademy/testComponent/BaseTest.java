package Veereshacademy.testComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Veereshcademy.Seleniumframework.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver intializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Veeresh W\\eclipse-workspace2\\Seleniumframework\\src\\main\\java\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
		//Chrome
			
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
		//Edge
			
		System.setProperty("webdriver.edge.driver", "edge.driver");
			 driver = new EdgeDriver();
			
		}
		
		//FireFox
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "gecko.driver");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod       
	public LandingPage launchApplication() throws IOException
	{
		driver = intializeDriver();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.GoTo();
		return landingpage;
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
