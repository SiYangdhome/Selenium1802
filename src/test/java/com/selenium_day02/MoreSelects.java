package com.selenium_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoreSelects {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    /**
     * 打开测试页面，按着ctrl键，选择不连续元素（选项）
     */
    @Test
    public void MoreSelectTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
       // WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list =driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
    }

    /**
     * 打开测试界面，按着shift键，选择联系的元素（选项）
     */
    @Test
    public void ShiftTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(3)).keyUp(Keys.SHIFT).perform();
    }

    /**
     * 打开百度页面，练习java提供的robot类，模拟键盘操作
     */
    @Test
    public void RobotTest() throws AWTException, InterruptedException {

        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * 上传图片
     */
    @Test
    public void UploadTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\huanghua.jpg");

    }
    @AfterMethod
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
