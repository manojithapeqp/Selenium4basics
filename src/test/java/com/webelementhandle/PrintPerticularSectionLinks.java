package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class PrintPerticularSectionLinks {
    @Test
    public void printPerticularSectionLinks() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/footer/nav"));
        List<WebElement> links = block.findElements(By.tagName("a"));
        System.out.println("Total Number of Links present is : " + links.size());
        for (WebElement link : links) {
            System.out.println(link.getText() + "<----URL is---->" + link.getAttribute("href"));
        }
        driver.close();
    }
}


