package com.devtoolprotocol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v121.emulation.Emulation;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;

import java.util.Optional;

public class MockGEOLocations {
    @Test
    public void mockGeoLocationsUsingDevToolProtocol() {

        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        //Here we pass Latitude, longitude and Accuracy
        devTools.send(Emulation.setGeolocationOverride(Optional.of(51.509865), Optional.of(-0.118092), Optional.of(100)));
        driver.get("https://www.gps-coordinates.net/my-location");
    }
}

