package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBsignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		WebElement birthday_day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select ddDay = new Select(birthday_day);
		ddDay.selectByVisibleText("1");
		
		WebElement birthday_month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select ddMonth = new Select(birthday_month);
		ddMonth.selectByVisibleText("Jan");
		
		WebElement birthday_year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select ddYear = new Select(birthday_year);
		ddYear.selectByVisibleText("1990");
		
		firstname.sendKeys("John");
		lastname.sendKeys("White");
		mobile.sendKeys("99999999999");
		password.sendKeys("Anc@1234");
		
		
		List<WebElement> list=driver.findElements(By.xpath("//select[@title='Month']/option"));
		for(WebElement month:list) {
			System.out.println(month.getText());
		}


String Gender = "Male";
		
		/*String genderXpath = "//label[text()='placeholder']";
		String newXpath = genderXpath.replace("placeholder", Gender);*/
		
		String newXpath = "//label[text()='" + Gender + "']";
		
		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();

		

	}

}
