package com.utilities;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
@Test
    public void readPropertyFileData() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/qed42/eclipse-workspace/SELENIUMBASICS/src/main/resources/object.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("Fees"));
        System.out.println(prop.getProperty("age"));
    }
}