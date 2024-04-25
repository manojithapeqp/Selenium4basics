package com.webelementhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class WindowsTabsHandle {
    @Test
    public void handleBrowserWindowsTabs() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//Store main window ID
        String mainWindow = driver.getWindowHandle();
//Open new Tab in same Browser
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Automation Testing");
//Open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.gmail.com");
        System.out.println("New Window Title is: " + driver.getTitle());

        System.out.println("total number of windows opened: " + driver.getWindowHandles().size());
        Set<String> winIDs = driver.getWindowHandles();
// Switch to the new windows
        for (String windowHandle : winIDs) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;}
        }
        // For example, get the title of the new window
        String newWindowTitle = driver.getTitle();
        System.out.println("Title of the new window: " + newWindowTitle);
        // Close the new window
        driver.close();
        // Switch back to the main window
        driver.switchTo().window(mainWindow);
    }
}
