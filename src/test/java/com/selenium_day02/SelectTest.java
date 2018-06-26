package com.selenium_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试界面
     * 选择下拉框
     * 分别通过索引、文本、value的值选择不同元素
     */
    @Test
    public void SelTest() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("moreSelect"));
        //实例化select类，调用select中的方法
        Select select = new Select(element);
        select.selectByValue("huawei");

        select.selectByIndex(3);

        select.selectByVisibleText("vivo");

    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
