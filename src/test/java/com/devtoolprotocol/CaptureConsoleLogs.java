package com.devtoolprotocol;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.console.Console;
import org.openqa.selenium.devtools.v121.log.Log;
import org.testng.annotations.Test;

public class CaptureConsoleLogs {
    @Test
    public void printConsoleLogs() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.send(Console.enable());
        devTools.addListener(Log.entryAdded(), entry -> {
            System.out.println("Text is : " + entry.getText());
            System.out.println("TimeStamp is : " + entry.getTimestamp());
            System.out.println("Source is : " + entry.getSource());
            System.out.println("Level is : " + entry.getLevel());
        });
        devTools.addListener(Console.messageAdded(), message -> {
            System.out.println("Console Text is : " + message.getText());
        });
        driver.get("http://flipkart.com");
        ((JavascriptExecutor) driver).executeScript("console.log('This is a sample log')");
    }
}
