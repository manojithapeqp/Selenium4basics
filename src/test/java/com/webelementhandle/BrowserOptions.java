package com.webelementhandle;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BrowserOptions {
    @Test
    public void browserOptionsSimulate() {
        Map<String, String> mobileEmulator = new HashMap<String, String>();
        mobileEmulator.put("deviceName", "iphone X");

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

// Add browser options and features
        options.setExperimentalOption("mobileEmulation", mobileEmulator);//Open mobile emulator on browser
        options.addArguments("window-size=1400,1000");
        options.addArguments("--start-maximized"); // Maximize browser window
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-infobars"); // Disable info bars
        options.addArguments("--disable-extensions"); // Disable browser extensions
        options.addArguments("--incognito"); // Launch browser in incognito mode
        options.addArguments("--headless"); // Run browser in headless mode (without UI)
        options.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        // Exclude automation info bar
        options.setAcceptInsecureCerts(true); // Accept insecure SSL certificates
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Set page load strategy
        options.setBinary("path_to_chrome_binary"); // Set path to Chrome binary
        options.addArguments("headless"); // Set headless mode
        //options.setProxy(proxy); // Set proxy configuration
        driver.get("https://www.selenium.dev/");
    }
}
