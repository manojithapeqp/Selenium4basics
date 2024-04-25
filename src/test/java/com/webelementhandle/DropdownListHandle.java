package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownListHandle {
    @Test
    public void handleDropdownList() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> dropdwn =driver.findElements(By.tagName("option"));
        int NumberOfOptions=dropdwn.size();
        for (int i=0;i<NumberOfOptions;i++){
            String language=dropdwn.get(i).getAttribute("lang");
        System.out.println(language);
        if(language.contains("ar")){
            Select slt=new Select(driver.findElement(By.id("searchLanguage")));
            slt.selectByValue(language);
            System.out.println("Manoj");
            Thread.sleep(10000);
        }
        }
        driver.close();
    }
}
