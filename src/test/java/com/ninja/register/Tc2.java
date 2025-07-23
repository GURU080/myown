package com.ninja.register;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ninja.testbase.Baseclass;
import com.ninja.utils.EmailUtils;

public class Tc2 extends Baseclass {

    @Test
    public void VerifyRegisterall() {
        // Navigate to Register Page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        // Fill Registration Form
        driver.findElement(By.id("input-firstname")).sendKeys("REVANT");
        driver.findElement(By.id("input-lastname")).sendKeys("SHAR");
        driver.findElement(By.id("input-email")).sendKeys(EmailUtils.generateUniqueEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("879876696");
        driver.findElement(By.id("input-password")).sendKeys("REV@123");
        driver.findElement(By.id("input-confirm")).sendKeys("REV@123");

        driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Assertion
        String expectedText = "Logout";
        String actualText = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).getText();
        Assert.assertEquals(actualText, expectedText, "Logout button is not present!");

        System.out.println("Registration Test Passed");
    }
}
