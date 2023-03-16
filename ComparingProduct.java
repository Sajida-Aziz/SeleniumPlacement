package testngpack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComparingProduct {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver(option);
		
		
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	WebElement searchbar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	searchbar.sendKeys("Apple iPhone 12 (64GB) - Black");
	searchbar.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (64GB) - Black']")).click();
	//String amt = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
	String amt  = driver.findElement(By.xpath("//span[text()='53,999']")).getText();
	Thread.sleep(2000);
	System.out.println(amt + "---- Amazon price ");
	
	driver.navigate().to("https://www.flipkart.com/");
	driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Apple iPhone 12 (64GB) - Black");
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[text()='APPLE iPhone 12 (Black, 64 GB)']")).click();
	String amtf = driver.findElement(By.xpath("//div[text()='₹53,999']")).getText();
	System.out.println(amtf + "----Flipkart Price");
	Thread.sleep(2000);
	
	double amazonamt=Double.parseDouble(amt.replace(",",""));
	System.out.println(amazonamt);
	
	double flipkartamt=Double.parseDouble(amtf.replaceAll("[^0-9]",""));
	System.out.println(flipkartamt);
	
	driver.quit();
	
	}

}
