package com.webelementhandle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptEcecutorCodeInject {
    @Test
    public void excecuteScript() {
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Call JavaScript function to scroll to the bottom of the page
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // Close the browser
        driver.quit();
    }
}
