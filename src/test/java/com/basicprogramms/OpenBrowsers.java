package com.basicprogramms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenBrowsers {

    @Test
    public void openBrowserTest(){

        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Define a Fluent Wait with a maximum timeout of 30 seconds and polling interval of 5 seconds
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("autocomplete")).sendKeys("India");
        driver.findElement(By.id("hide-textbox")).click();
        WebElement showBox=driver.findElement(By.id("displayed-text"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("displayed-text"))).sendKeys("TestUser");
        driver.quit();
    }
}
