package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Node2
{
    static WebDriver driver;
    static String NodeUrl;

    @Test
    public void test1() throws Exception {

        NodeUrl = "http://192.168.1.11:35801/wd/hub";

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL(NodeUrl), capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

        driver.get("http://www.yatra.com");
        System.out.println("The Title is: "+driver.getTitle());
        Thread.sleep(4000);
        driver.close();
    }
}
