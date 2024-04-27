package com.webelementhandle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CaptureElementCordinates {
    @Test
    public void captureElementsCoordinates() {
        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement textBox= driver.findElement(By.xpath("//*[@id=\"autocomplete\"]"));

        Rectangle rect=textBox.getRect();
        System.out.println("Height :" + rect.height);
        System.out.println("Width : "+rect.width );
        System.out.println("X Coordinate :" + rect.x);
        System.out.println("Y Coordinate : "+ rect.y );
        System.out.println("------Done------");
    }
}
