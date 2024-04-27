package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class JquerySliderHandle {
    @Test
    public void handleSliderExample() {
        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        driver.get("https://jqueryui.com/slider/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Capture Slider strip locator
        WebElement mainSliderStrip = driver.findElement(By.id("slider"));
        //To move slider at half position we devide width in half
        int widthOfSlider = mainSliderStrip.getSize().width / 2;
        //Identify slider pointer locator
        WebElement sliderPointer = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        //Here create object of Action class
        Actions act = new Actions(driver);
        //Pass locator and diamention to slide
        act.dragAndDropBy(sliderPointer, widthOfSlider, 0).build().perform();
    }
}
