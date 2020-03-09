package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    public static void main(String[] args) {

        safariTest();
        chromeTest();
        firefoxTest();
    }

    public static void safariTest(){

        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("http://google.com");
        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2,driver.getTitle());


        driver.quit();
    }

    public static void chromeTest(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2,driver.getTitle());


        driver.quit();
    }

    public static void firefoxTest(){

        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("http://google.com");
        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title1,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title2,driver.getTitle());


        driver.quit();
    }



}
