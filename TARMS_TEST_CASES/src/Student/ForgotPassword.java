package Student;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Program Files\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("forgotPass")).click();
		
		Thread.sleep(3000);
		
		WebElement eMail=driver.findElement(By.id("Pass"));
		eMail.sendKeys("ABC@thapar");
		WebElement submit=driver.findElement(By.tagName("button"));
		submit.click();
		
		boolean result=checkAlerts(driver);
		if(result==true)
		{
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
	
	public static boolean checkAlerts(ChromeDriver driver)
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
