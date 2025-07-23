package com.ninja.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ninja.testbase.Baseclass;

public class Tcl001 extends Baseclass {

    @Test
    public void verifyWithValidCredentials() {
        // Navigate to login page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();

        // Enter credentials
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("guru1234g@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345678");

        // Click login
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Validate logout link
        String actual = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).getText();
        Assert.assertEquals(actual, "Logout", "Login failed!");
        
        
        System.out.println("test pass - verifyWithValidCredentials ");
    }
}
