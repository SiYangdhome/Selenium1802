package com.selenium_day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * 打开百度页面，右键百度按钮
     */
    @Test
    public void RightClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.id("su"));
        //实例化 Actions类
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }


    /**
     * 打开百度页面，双击
     * @throws InterruptedException
     */

    @Test
    public void DoubleClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    /**
     * 打开测试页面，鼠标移动到Actions按钮
     * @throws InterruptedException
     */
    @Test
    public void MoveTest() throws InterruptedException {

        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
        System.out.println(hello);
        Assert.assertEquals(hello,"Hello World!");

    }

    /**
     * 打开移动测试页面，将图标移动到指定地点（坐标）
     * @throws InterruptedException
     */
    @Test
    public void DragandDropTest() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 500,800).perform();

    }
//*[@id="selectWithMultipleEqualsMultiple"]/option
    /**
     * 打开drop测试界面，将元素1移动到元素2上
     * @throws InterruptedException
     */
    @Test
    public void DropMoveToTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/dragAndDrop.html");
        WebElement ele1 = driver.findElement(By.xpath("/html/body/h1"));
        WebElement ele2 = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(ele2).moveToElement(ele1).release(ele2).perform();

    }



    @AfterMethod
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
