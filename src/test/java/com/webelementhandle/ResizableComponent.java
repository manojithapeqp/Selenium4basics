package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResizableComponent {
    @Test
    public void handleResizableComponent() {
        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement source = driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"div2\"]"));
        Actions act = new Actions(driver);
        act.dragAndDrop(source, destination).perform();
    }
}
