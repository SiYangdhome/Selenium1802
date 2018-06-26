package com.selenium_day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActions {

    WebDriver driver;


    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");

    }

    /**
     * 启动火狐浏览器
     * 点击返回
     * 等待3s
     * 点击前进
     * 等待3s
     * 点击刷新
     * 关闭浏览器
     */
    @Test
    public void BrowserAction() throws InterruptedException {

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();

    }

    /**
     * 设置浏览器大小、最大化
     *
     */

    @Test
    public void BrowserSize() throws InterruptedException {
        Dimension dimension = new Dimension(500,800);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    /**
     * 打开百度首页
     * 获取当前URL
     * 校验是否正确
     * 关闭浏览器
     */
    @Test
    public void GetUrl(){
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"https://www.baidu.com/");

    }


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}


