package Student;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feedback 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Program Files\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		
		WebElement user=driver.findElement(By.id("User"));
		user.sendKeys("SnitchAdmin");
		WebElement password=driver.findElement(By.id("Pass"));
		password.sendKeys("Haveaniceday1@");
		
		Thread.sleep(3000);
		
		WebElement submit=driver.findElement(By.id("lin"));
		submit.click();
		
		Thread.sleep(5000);
		
		WebElement PI=driver.findElement(By.xpath("//a[contains(text(),'Feedback')]"));
		PI.click();
		
		Thread.sleep(3000);
		
		WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
		Name.clear();
		Name.sendKeys("Hello");
		List<WebElement> rate=driver.findElements(By.xpath("//form/input[@name='rate']"));
		rate.get(2).click();
		//WebElement reset=driver.findElement(By.xpath("//input[@type='reset']"));
		//reset.click();
		WebElement submitFeed=driver.findElement(By.xpath("//input[@type='submit']"));
		submitFeed.click();
		
		boolean result=checkAlerts(driver);
		if(result==true)
		{
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	public static boolean checkAlerts(WebDriver driver)
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException Ex){
			return false;
		}
	}

}
