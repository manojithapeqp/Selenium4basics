package com.basicprogramms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FetchAllWebElements {
    @Test
    public void learnRelativeLocatorAndFetchAllWebElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List <WebElement> allLabels =driver.findElements(with(By.tagName("label"))
                .below(By.xpath("//*[@id=\"load_form\"]/h3")));
            for (WebElement lbl: allLabels){
                System.out.println(lbl.getText());
            }
    }
}

