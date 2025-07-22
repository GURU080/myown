package com.ninja.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tcl001 {


	@Test
	public void verfiywithvalidcrednetials() {
		
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.manage().window().maximize();
	    driver.get("https://tutorialsninja.com/demo/");

	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
	  
	    driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("guru1234g@gmail.com");
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345678");
	    
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	    
	      
	}


}
