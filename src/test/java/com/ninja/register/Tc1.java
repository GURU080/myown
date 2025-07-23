package com.ninja.register;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import com.ninja.testbase.Baseclass;
import com.ninja.utils.EmailUtils;

public class Tc1 extends Baseclass {
    

    
    @Test
    public void registerAccount() {
    	
    	
    	
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("REVANT");
        driver.findElement(By.id("input-lastname")).sendKeys("SHAR");
        driver.findElement(By.id("input-email")).sendKeys(EmailUtils.generateUniqueEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("879876696");
        driver.findElement(By.id("input-password")).sendKeys("REV@123");
        driver.findElement(By.id("input-confirm")).sendKeys("REV@123");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        // Validate Logout link presence
        String expected = "Logout";
        String actual = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).getText();
        Assert.assertEquals(actual, expected, "Logout button is not present!");
        
        
        System.out.println("tesst pass  registerAccount");
    }
    
 
    
}
