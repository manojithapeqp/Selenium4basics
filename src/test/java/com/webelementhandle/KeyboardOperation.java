package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyboardOperation {
    @Test
    public void performKeyboardOperation(){
        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"target\"]"));
        WebElement clickOutside=driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]"));
        //Enter text and press enter key
        //textBox.sendKeys("manoj");
        //textBox.sendKeys(Keys.ENTER);
        //Copy and paste the data in field
        clickOutside.click();
        Actions act=new Actions(driver);
        act.sendKeys(Keys.chord(Keys.CONTROL+"a")).sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();
        textBox.click();
        act.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
    }
}
