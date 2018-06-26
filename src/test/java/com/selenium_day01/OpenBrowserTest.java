package com.selenium_day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    WebDriver driver;

    @Test
    public void OpenFireFox(){

        //    火狐浏览器为<48版本，并且为默认安装路径可以这样启动

        driver = new FirefoxDriver();
    }


    @Test
    public void OpenFF(){

        //火狐浏览器为<48版本，但是不是默认安装路径

        System.setProperty("Webdriver.FireFox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }


    @Test
    public void OpenChrome(){

        //谷歌浏览器必须要下载对应的driver，然后才能启动
        System.setProperty("webdriver.chrome.driver","E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://p.moonpool.com.cn:8080");


    }

    @Test
    public void OpenIE(){
        //下载iedriver后，启动

        System.setProperty("webdriver.ie.driver","E:\\selenium_demo1802\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
