package com.selenium_day02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions {

    WebDriver driver;

    //点击、输入文本、清空、获取文本
    @BeforeMethod
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度，输入文本：小土科技，点击百度一下
     */
    @Test
    public void clickTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("小土科技");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String text1 = driver.getTitle();
        Assert.assertEquals(text1,"小土科技_百度搜索");
    }

    /**
     * 打开百度首页，获取新闻链接的文本内容
     *
     */
    @Test
    public void GetTextTest(){
        driver.get("https://www.baidu.com/");
        String text2 = driver.findElement(By.linkText("新闻")).getText();
        System.out.println(text2);
        Assert.assertEquals(text2,"新闻");
    }

    /**
     * 打开百度首页，获取百度一下按钮的标签名"getTagName()"
     */
    @Test
    public void GetTagNameTest(){
        driver.get("https://www.baidu.com/");
        String tagname = driver.findElement(By.id("su")).getTagName();
        Assert.assertEquals(tagname,"input");
    }

    /**
     * 打开百度首页，获取百度按钮显示的预设默认值是否为“百度一下”
     */

    @Test
    public void getAttributeTest(){
        driver.get("https://www.baidu.com/");
        String Attribute = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(Attribute,"百度一下");
    }

    /**
     * 打开百度页面
     * 判断百度按钮是否展示
     */
    @Test
    public void isDisplayedTest(){
        driver.get("https://www.baidu.com/");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);

    }

    /**
     * 打开测试页面，判断单选框volvo是否选中状态
     */
    @Test
    public void isSelectedTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面，判断submit按钮是否处于未激活状态
     */
    @Test
    public void isEnableTest(){
        driver.get("file:///C:/Users/Administrator/Desktop/selenium_html/index.html");
        Boolean b = driver.findElement(By.xpath("//*[@id=\"button\"]/input")).isEnabled();
        Assert.assertFalse(b);
    }



    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

