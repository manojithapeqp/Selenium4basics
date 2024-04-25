package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class selectAllCheckboxes {
    @Test
    public void checkAllCheckBoxes() {
        Object WebDriverManager;

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       /* for (int i = 1; i < 4; i++) {
            String checkbox = "checkBoxOption" + i;
            //Actual xpath --> //*[@id="checkBoxOption2"]
            WebElement chechbox = driver.findElement(By.xpath("//*[@id=\"" + checkbox + "\"]"));
            chechbox.click();*/
        WebElement checkboxSection = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset"));
        List<WebElement> cb = checkboxSection.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("Number of Checkboxes is: " + cb.size());
        for (WebElement chckbx : cb) {
            chckbx.click();
        }
    }
}

