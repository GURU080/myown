package com.ninja.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninja.testbase.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tcl005  extends Baseclass  {
	
	@Test

	public void verifywithONLYEMIALFIELD() {
		
	

	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
	  
	    driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("GURU@gmail.com");
	    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
	    
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	    String EP="Warning: No match for E-Mail Address and/or Password.";
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),EP);
	    
	    System.out.println("test pass - verifywithONLYEMIALFIELD ");
}
}
