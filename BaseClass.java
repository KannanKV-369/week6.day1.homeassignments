package week6.day1.homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ChromeDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void preCondition()
	{
		//Call WebDriverManager for the brower driver
		WebDriverManager.chromedriver().setup();
		//Lauch the brower Chrome
		driver = new ChromeDriver();
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize the browser
		driver.manage().window().maximize();
		//Enter First Name
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login Button
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@AfterMethod
	public void postCondition()
	{
		driver.quit();	
	}

}
