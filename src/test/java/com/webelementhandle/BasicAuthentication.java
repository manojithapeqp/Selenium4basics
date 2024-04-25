package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicAuthentication {
    @Test
    public void seleniumBasicAuthentication() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //New way in selenium 4 is below
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
        driver.get("https://the-internet.herokuapp.com/");

        //Old way to enter UN and PW in URL as below
        // driver.get("https://admin:admin@the-internet.herokuapp.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Check whether successfully login or not
        String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "Congratulations! You must have the proper credentials.");
    }
}
