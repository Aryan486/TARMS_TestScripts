package Student;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingRequest 
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
		
		Thread.sleep(2000);
		
		int index=3;
		List<WebElement> buttons=driver.findElements(By.xpath("//a[contains(text(),'Book')]"));
		buttons.get(index).click();
		
		Thread.sleep(3000);
		
		//WebElement name=driver.findElement(By.id("getName"));
		//name.clear();
		//name.sendKeys("Hello");
		
		Select branch=new Select(driver.findElement(By.name("branch")));
		branch.selectByVisibleText("COE");
		
		Select year=new Select(driver.findElement(By.name("year")));
		year.selectByVisibleText("3rd");
		
		WebElement mobile=driver.findElement(By.id("getMobile"));
		mobile.clear();
		mobile.sendKeys("1234567890");
		
		Select society=new Select(driver.findElement(By.name("society")));
		society.selectByVisibleText("Society 4");
		
		WebElement eventName=driver.findElement(By.id("getEvent"));
		eventName.sendKeys("My new event");
		
		WebElement purpose=driver.findElement(By.id("getPurpose"));
		purpose.sendKeys("My new purpose");
		
		WebElement date=driver.findElement(By.xpath("//input[@type='date']"));
		String date1 = "09";
		String date2 = "05";
		String date3 = "2022";
		date.sendKeys(date1);
		date.sendKeys(date2);
		date.sendKeys(date3);
		
		List<WebElement> times=driver.findElements(By.xpath("//input[@type='time']"));
		times.get(0).sendKeys("0530PM");
		times.get(1).sendKeys("0630PM");
	
		List<WebElement> people=driver.findElements(By.xpath("//input[@type='number']"));
		people.get(1).clear();
		people.get(1).sendKeys("25");
		
		List<WebElement> ac=driver.findElements(By.xpath("//input[@name='AC']"));
		ac.get(1).click();
		
		List<WebElement> ss=driver.findElements(By.xpath("//input[@name='SS']"));
		ss.get(0).click();
		
		Thread.sleep(3000);
		
		WebElement reset=driver.findElement(By.xpath("//input[@type='reset']"));
		reset.click();
		
		WebElement submitReq=driver.findElement(By.xpath("//input[@type='submit']"));
		submitReq.click();
		
		boolean result=checkAlerts(driver);
		if(result==true)
		{
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(4000);
		
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
