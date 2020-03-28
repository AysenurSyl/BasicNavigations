package com.cbt.tests;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Homework {

        private WebDriver driver;

    @BeforeMethod
        public void setup(){
            driver = DriverFactory.createDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com");
            BrowserUtils.wait(3);
            driver.findElement(By.linkText("Registration Form")).click();

        }

        @AfterMethod
        public void teardown(){
            driver.quit();
        }

        @Test
        public void TestCase1(){
            driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
            String actual = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-for=\"birthday\"][2]")).getText();
            String expected = "The date of birth is not valid";

            Assert.assertEquals(actual, expected);
        }

        @Test
        public void TestCase2(){
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));
            Assert.assertEquals(elements.get(0).getText(), "C++");
            Assert.assertEquals(elements.get(1).getText(), "Java");
            Assert.assertEquals(elements.get(2).getText(), "JavaScript");

        }

        @Test
        public void TestCase3(){
            driver.findElement(By.name("firstname")).sendKeys("s");
            String actual = driver.findElement(By.xpath("//small[@data-bv-for=\"firstname\"][2]")).getText();
            String expected = "first name must be more than 2 and less than 64 characters long";
            Assert.assertEquals(actual, expected);
        }

        @Test
        public void TestCase4(){
            driver.findElement(By.name("lastname")).sendKeys("b");
            String actual = driver.findElement(By.xpath("//small[@data-bv-for=\"lastname\"][2]")).getText();
            String expected = "The last name must be more than 2 and less than 64 characters long";
            Assert.assertEquals(actual, expected);

        }

        @Test
        public void TestCase5(){
            driver.findElement(By.name("firstname")).sendKeys("Ayse");
            driver.findElement(By.name("lastname")).sendKeys("Soylu");
            driver.findElement(By.name("username")).sendKeys("aysenur");
            driver.findElement(By.name("email")).sendKeys("ayse_nur4@hotmail.com");
            driver.findElement(By.name("password")).sendKeys("pas*word*");
            driver.findElement(By.name("phone")).sendKeys("767-899-9767");
            driver.findElements(By.name("gender")).get(2).click();
            driver.findElement(By.name("birthday")).sendKeys("01/28/1990");
            new Select(driver.findElement(By.name("department"))).getOptions().get(2).click();
            new Select(driver.findElement(By.name("job_title"))).getOptions().get(1).click();
            driver.findElement(By.id("inlineCheckbox2")).click();
            driver.findElement(By.id("wooden_spoon")).click();

            String actual = driver.findElement(By.xpath("//p")).getText();
            String expected = "You've successfully completed registration!";

            Assert.assertEquals(actual, expected);


        }
    }


