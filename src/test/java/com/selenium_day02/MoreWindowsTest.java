package com.selenium_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoreWindowsTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 多窗口处理
     * 打开测试界面
     * 点击OPEN new Window,点击该页面的“baidu"按钮
     *
     */
     @Test
     public void WindowsActionTest() throws InterruptedException {
         driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
         driver.findElement(By.linkText("Open new window")).click();
         //获取当前页面handle值（句柄值）
         String handle1 = driver.getWindowHandle();
         //for 循环对比两个页面句柄值，如果与当前页面句柄值相同，继续循环，如果不同，转交控制权，
         for(String handles : driver.getWindowHandles())
             if(handles.equals(handle1)){
                continue;
             }else
              driver.switchTo().window(handles);
         driver.findElement(By.linkText("baidu")).click();
         Thread.sleep(3000);
         //将控制权转交给原来页面
         driver.switchTo().window(handle1);
     }


    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}