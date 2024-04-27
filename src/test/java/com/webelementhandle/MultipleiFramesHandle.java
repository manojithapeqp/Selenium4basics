package com.webelementhandle;

import com.basicprogramms.FetchAllWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MultipleiFramesHandle {
    @Test
    public void handleMultipleIFrames() {
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to a webpage with an alert
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iFrames present :" + frames.size());
        for (WebElement frame : frames) {
            String frameID = frame.getAttribute("id");
            System.out.println(frameID);
            if (frameID.equals("courses-iframe")) {
                driver.switchTo().frame("courses-iframe");
            } else {
                System.out.println("Required iFrame not present");
            }
        }
        WebElement wb = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[1]/ul/li"));
        System.out.println(wb.getText());
        //Move selenium Focus from iFrame to main page
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());
    }
}