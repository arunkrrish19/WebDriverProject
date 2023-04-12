package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("arun@xyz.com");
		
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys("2324324");
		
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		
		WebElement error = driver.findElement(By.className("_9ay7"));
		String _9ay7 = error.getText();
		String experror = "The email address you entered isn't connected to an account. Find your account and log in.";
		
		if(error.isDisplayed() && _9ay7.equals(experror))  {
			System.out.println("TC Passed");
		}
		else
		{	
			System.out.println("TC Failed");
	}
		driver.close();
	}
}
