package com.ninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ninja.testbase.Baseclass;
import com.ninja.utils.EmailUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_006 extends Baseclass {
	
	
     @Test
	public void verifyregisterwithnonewsletter () {

		

	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.xpath("//a[text()='Register']")).click();
	    driver.findElement(By.id("input-firstname")).sendKeys("REVANT");
	    driver.findElement(By.id("input-lastname")).sendKeys("SHAR");

	    driver.findElement(By.id("input-email")).sendKeys(EmailUtils.generateUniqueEmail());
	    driver.findElement(By.id("input-telephone")).sendKeys("879876696");
	    driver.findElement(By.id("input-password")).sendKeys("REV@123");
	    driver.findElement(By.id("input-confirm")).sendKeys("REV@123");
	    
	    
	    
    driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();

   driver.findElement(By.name("agree")).click();
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	    System.out.println("test pass verifyexistingemail");    


	}

}
