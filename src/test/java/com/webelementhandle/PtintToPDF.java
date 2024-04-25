package com.webelementhandle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class PtintToPDF {
    @Test
    public void printToPDF() throws IOException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("headless");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Pdf pdf = ((PrintsPage) driver).print((new PrintOptions()));
        Files.write(Paths.get("./Selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
    }
}
