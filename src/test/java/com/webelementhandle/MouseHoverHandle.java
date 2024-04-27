package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseHoverHandle {
    @Test
    public void handleMouseHover() {
        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement textBox = driver.findElement(By.xpath("(//span[@dir='ltr'][contains(.,'हिन्दी')])[1]"));
        Actions act = new Actions(driver);
        act.moveToElement(textBox).build().perform();
        textBox.click();
    }
}
