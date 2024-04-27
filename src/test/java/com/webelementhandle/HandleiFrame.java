package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleiFrame {
    @Test
    public void handleiFrames() {

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to a webpage with an alert
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //From main page to iFrame we switch selenium focus
        driver.switchTo().frame("courses-iframe");
        WebElement wb = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[1]/ul/li"));
        System.out.println(wb.getText());
        //Move selenium Focus from iFrame to main page
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());
    }
}
