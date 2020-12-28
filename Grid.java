package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Grid
{
    static WebDriver driver;
    static String NodeUrl;

    public static void main(String[] args) throws Exception
    {
        NodeUrl="http://192.168.1.2:15599/wd/hub";

        DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL(NodeUrl),capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);

        driver.get("http://www.amazon.in");
        driver.findElement(By.linkText("Today's Deals")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
