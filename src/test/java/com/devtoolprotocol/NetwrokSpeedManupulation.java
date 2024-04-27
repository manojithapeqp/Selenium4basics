package com.devtoolprotocol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetwrokSpeedManupulation {
    @Test
    public void networkSpeedManupulation() {
        WebDriver driver = new ChromeDriver();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 100,
                20000, 10000, Optional.of(ConnectionType.CELLULAR4G)));

        driver.get("http://way2automation.com");
    }
}
