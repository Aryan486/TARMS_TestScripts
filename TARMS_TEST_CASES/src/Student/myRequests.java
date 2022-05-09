package Student;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myRequests 
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
		
		WebElement PI=driver.findElement(By.xpath("//a[contains(text(),'My')]"));
		PI.click();
		
		Thread.sleep(3000);
		
		List<WebElement> cancelButton=driver.findElements(By.xpath("//input[@type='submit']"));
		
		if(cancelButton.isEmpty()==false)
		{
			int index=1;
			if(index>cancelButton.size()-1)
			{
				index=cancelButton.size()-1;
			}
			cancelButton.get(index).click();
		}
		
		Thread.sleep(6000);
		
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
