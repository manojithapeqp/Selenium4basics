package com.devtoolprotocol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;
import org.testng.annotations.Test;

public class OverrideTimezoneValues {
    @Test
    public void overrideTimeZoneValuesUsingDevTool() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://whatismytimezone.com/");
        Thread.sleep(5000);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setTimezoneOverride("EST"));
        driver.get("https://whatismytimezone.com/");
    }
}
