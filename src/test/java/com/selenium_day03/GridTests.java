package com.selenium_day03;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTests {
    /**
     * 通过grid跑脚本
     */

    WebDriver driver;

    @Test
    public void OpenBrowser() throws MalformedURLException, InterruptedException {


        DesiredCapabilities dc = DesiredCapabilities.chrome();

        driver = new RemoteWebDriver(new URL("http://192.168.1.101:4444/wd/hub"), dc);

        driver.get("https://www.baidu.com/");
        Thread.sleep(5000);
        driver.quit();


    }

    /**
     * 数据驱动，一条用例在不同浏览器运行
     */
    @DataProvider(name = "wjtest")
    public Object[][] test1() {
        return new Object[][]{
                {"firefox"},
                {"chrome"}
        };
    }


    @Test(dataProvider = "wjtest")
    public void DataTest(String browser) throws MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser.equals("firefox")) {
             dc = DesiredCapabilities.firefox();
        }else if (browser.equals("chrome")){
             dc = DesiredCapabilities.chrome();
        }else
            System.out.println("error");

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.101:4444/wd/hub"),dc);
        driver.get("https://www.baidu.com/");
        driver.quit();
    }


}