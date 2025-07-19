package com.ninja.register;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import com.ninja.utils.EmailUtils;

public class VerifyRegisteronlymandatoryfileds {

       @Test
    public void VerifyRegister() {
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

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        
        //vlaidate the page 
        
        String al="Your Account Has Been Created!";
        String ep=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
        
//        if(al.equals(ep)) {
//        	System.out.println("account created pass");
//        }
//        else {
//        	System.out.println("failed");
//        }
//        
        
        Assert.assertEquals(al, ep,"Account creation validation failed!");

        driver.quit();
    }
}
