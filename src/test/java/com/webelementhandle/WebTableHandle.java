package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTableHandle {
    @Test
    public void printAllDataInWebTable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement table = driver.findElement(By.xpath("//html/body/div[3]/div[1]/fieldset"));
        List<WebElement> rowsNumbers = table.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr"));
        System.out.println("Total Number of Rows in Table: " + rowsNumbers.size());

        for (int row = 1; row <= rowsNumbers.size(); row++) {
            for (int colomn = 1; colomn <= row; colomn++) {
                WebElement data=table.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr["+colomn+"]/td["+row+"]"));
                System.out.println(data);
            }
        }
    }
}