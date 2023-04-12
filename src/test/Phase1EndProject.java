package test;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Phase1EndProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		WebElement searchAmz = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		searchAmz.sendKeys("Samsung mobile");
		Thread.sleep(2000);
	
		WebElement btn_search = driver.findElement(By.id("nav-search-submit-button"));
		btn_search.click();
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("src/Selenium/screenshot.png");
		
		FileUtils.copyFile(fileObj, screenshotObj);
		
		List<WebElement> product_names = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		
		List<WebElement> product_price = driver.findElements(By.xpath("//div[@class='a-section']//a//span[@class='a-price-whole']"));
		
		List<WebElement> currency = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		for(int i=0;i<product_names.size();i++)
		{
				System.out.println("Product : " + product_names.get(i).getText());
				System.out.println("Price : "+currency.get(i).getText() + " " +product_price.get(i).getText());
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		TakesScreenshot tsObj1 = (TakesScreenshot) driver;
		File fileObj1 = tsObj1.getScreenshotAs(OutputType.FILE);
		File screenshotObj1 = new File("image.png");
		
		FileUtils.copyFile(fileObj1,screenshotObj1);
		driver.close();
		
	}

}