package com.ninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninja.utils.EmailUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc2 {
	
	
	   @Test
	    public void VerifyRegisterall() {
	
	WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.manage().window().maximize();
    driver.get("https://tutorialsninja.com/demo/");

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
    

    
    String al="Logout";
    String ep=driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).getText();
   
 
    
    Assert.assertEquals(al, ep,"logout button is presnt!");

   driver.quit();
    
}
}