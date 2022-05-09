package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logout
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
	
		String handleBefore=driver.getWindowHandle();
		
		WebElement PI=driver.findElement(By.xpath("//a[contains(text(),'Log')]"));
		PI.click();
		
		Thread.sleep(3000);
		
		Set<String> handles=driver.getWindowHandles();
		List<String> lHandles=new ArrayList<String>(handles);
		
		for(String e:lHandles)
		{
			if(e.endsWith(handleBefore))
			{
				driver.switchTo().window(e);
				break;
			}
		}
		
		Thread.sleep(3000);
		
		WebElement PI2=driver.findElement(By.xpath("//a[contains(text(),'Personal')]"));
		PI2.click();
		
		Thread.sleep(4000);
		
		driver.quit();
	}
}
