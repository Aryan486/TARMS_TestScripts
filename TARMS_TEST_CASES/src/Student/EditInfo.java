package Student;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditInfo 
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
		
		WebElement PI=driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
		PI.click();
		
		Thread.sleep(3000);
		
		WebElement cMob=driver.findElement(By.id("curr_mob"));
		cMob.clear();
		cMob.sendKeys("7508516533");
		WebElement cUid=driver.findElement(By.id("curr_uid"));
		cUid.clear();
		cUid.sendKeys("SnitchAdmin");
		WebElement nMob=driver.findElement(By.id("new_mob"));
		nMob.sendKeys("1234567898");
		WebElement nUid=driver.findElement(By.id("new_uid"));
		nUid.sendKeys("SnitchAdmin");
		
		Thread.sleep(4000);
		
		//WebElement reset=driver.findElement(By.xpath("//input[@type='reset']"));
		//reset.click();
		WebElement submitInfo=driver.findElement(By.xpath("//input[@type='submit']"));
		submitInfo.click();
		boolean res=checkAlerts(driver);
		if(res==true)
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
