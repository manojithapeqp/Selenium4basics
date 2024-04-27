package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleTabsAndPopUP {
    @Test
    public void handleTabsAndPopUPs(){
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        // Navigate to a webpage with multiple pop-ups or windows
        driver.get("https://www.example.com");
        // Get the window handle of the main window
        String mainWindowHandle = driver.getWindowHandle();
        // Click on a link or button that opens a new window or pop-up
        driver.findElement(By.linkText("Open New Window")).click();
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Interact with elements inside the new window or pop-up
        driver.findElement(By.id("element_in_new_window")).click();
        // Switch back to the main window (if needed)
        driver.switchTo().window(mainWindowHandle);
        // Interact with elements in the main window
        driver.findElement(By.id("element_in_main_window")).click();
        // Close the browser
        driver.quit();
    }
}

