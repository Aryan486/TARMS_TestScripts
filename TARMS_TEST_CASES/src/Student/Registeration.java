package Student;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registeration 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Program Files\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("signup")).click();
		
		Thread.sleep(4000);
		
		WebElement name=driver.findElement(By.id("Name"));
		name.sendKeys("Name123");
		WebElement uid=driver.findElement(By.id("Uid"));
		uid.sendKeys("myID1");
		WebElement mail=driver.findElement(By.id("mail"));
		mail.sendKeys("Abcd@thapar.edu");
		WebElement mobile=driver.findElement(By.id("phone"));
		mobile.sendKeys("1234567888");
		WebElement BirthDate= driver.findElement(By.id("dob"));
		BirthDate.clear();
		BirthDate.sendKeys("20-Aug-1985");
		WebElement password=driver.findElement(By.id("pass"));
		password.sendKeys("Hello123@");
		WebElement submit=driver.findElement(By.id("button1"));
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
