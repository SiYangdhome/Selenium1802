package com.selenium_day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void byIDTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement keyinput = driver.findElement(By.id("kw"));
        keyinput.sendKeys("小土科技");
        driver.findElement(By.id("su")).click();

    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
