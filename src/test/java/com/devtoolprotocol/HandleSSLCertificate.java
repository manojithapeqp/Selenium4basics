package com.devtoolprotocol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleSSLCertificate {
    @Test
    public void handleSSLCertificates() {
        WebDriver driver = new ChromeDriver();
        //Create DevTool Session
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        // Obtain DevTools session
        devTools.createSession();

        //Enable Security
        devTools.send(Security.enable());
        //Ignore SSLCertificate Error
        devTools.send(Security.setIgnoreCertificateErrors(true));

        driver.get("https://expired.badssl.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
