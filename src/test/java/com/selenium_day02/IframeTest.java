package com.selenium_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        driver.switchTo().frame("aa");
        driver.findElement(By.linkText("baidu")).click();

        String text = driver.findElement(By.id("su")).getAttribute("value");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"id01\"]")).click();

        String tatle = driver.getTitle();
        Assert.assertEquals(text,"百度一下");
        Assert.assertEquals(tatle,"百度一下，你就知道");
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
