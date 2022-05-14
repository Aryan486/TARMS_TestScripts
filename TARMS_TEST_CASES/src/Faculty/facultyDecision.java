package Faculty;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facultyDecision 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Program Files\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		
		WebElement fac=driver.findElement(By.id("facLogin"));
		fac.click();
		
		WebElement user=driver.findElement(By.id("User"));
		user.sendKeys("Admin");
		WebElement password=driver.findElement(By.id("Pass"));
		password.sendKeys("Goodday1!");
		
		Thread.sleep(4000);
		
		WebElement submit=driver.findElement(By.id("lin"));
		submit.click();
		
		boolean res=checkAlerts(driver);
		if(res==true)
		{
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
		
		List<WebElement> decision=driver.findElements(By.xpath("//input[@type='submit']"));
		int index=1;    //index=1 for reject and index=0 for accept
		decision.get(index).click();
		
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
