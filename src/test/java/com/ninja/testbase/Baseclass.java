package com.ninja.testbase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    
    public static WebDriver driver;

    @BeforeClass
    public void launchBrowser() { // Removed String browserName
        String browserName = "chrome"; // default browser

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name! Launching Chrome as default.");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @BeforeMethod
    public void Login() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
    }

    @AfterMethod
    public void Logout() {
        try {
            if (driver != null) {
                // Check if browser session is active
                if (((ChromeDriver) driver).getSessionId() != null) {
                    if (driver.findElements(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).size() > 0) {
                        driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
                        System.out.println("Logout successful.");
                    } else {
                        System.out.println("Logout link not found - possibly invalid login test.");
                    }
                } else {
                    System.out.println("Driver session already closed. Skipping logout.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in Logout method: " + e.getMessage());
        }
    }



    @AfterClass
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
