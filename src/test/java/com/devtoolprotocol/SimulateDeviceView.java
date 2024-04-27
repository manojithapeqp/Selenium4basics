package com.devtoolprotocol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SimulateDeviceView {
    @Test
    public void simulateDeviceView() {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        Map<String, Object> deviceMetrics = new HashMap<String, Object>() {
            {
                put("width", 200);
                put("height", 600);
                put("mobile", true);
                put("deviceScaleFactor", 60);
            }
        };
        ((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://selenium.dev/");
    }
}

