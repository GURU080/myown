package com.ninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tcr_004 {
	
	
	@Test
	public void verifyregisterwithoutdetails() {
		
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.manage().window().maximize();
	    driver.get("https://tutorialsninja.com/demo/");

	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.xpath("//a[text()='Register']")).click();
	    
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	    String expectedfirstname= "First Name must be between 1 and 32 characters!";
	    String expectedlastname= "Last Name must be between 1 and 32 characters!";
	    String expectedemail= "E-Mail Address does not appear to be valid!";
	    String expectedphone= "Telephone must be between 3 and 32 characters!";
	    
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), expectedfirstname);
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), expectedlastname);
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(), expectedemail);
	    
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), expectedphone);
	    
	    driver.quit();
	}

}
