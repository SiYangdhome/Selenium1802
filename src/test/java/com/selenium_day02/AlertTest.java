package com.selenium_day02;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        Assert.assertEquals(text,"我是提示信息");
    }

    @Test
    public void promptTest() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt弹窗");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
