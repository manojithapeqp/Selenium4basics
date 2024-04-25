package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframeExample {
    @Test
    public void handleIframeExample(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement iFrame =driver.findElement(By.tagName("iframe"));
        System.out.println("Total number of iFramers: "+ iFrame.getSize());

        //driver.switchTo().frame(0);
        driver.switchTo().frame("courses-iframe");

        WebElement email=driver.findElement(By.xpath("//li[contains(.,'contact@rahulshettyacademy.com')]"));
        String actualEmailID=email.getText();
        String expStringEmail="contact@rahulshettyacademy.com";
        if (actualEmailID.equals(expStringEmail)){
            System.out.println("Driver Switched to iFrame and Testcase is passed");
        }
    }
}
