package com.devtoolprotocol;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class BlockNetworkRequest {
    @Test
    public void blockNetworkRequest() {
        WebDriver driver = new ChromeDriver();

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", ".png", "*.jpeg")));

        driver.get("https://www.makemytrip.com/");
    }
}
