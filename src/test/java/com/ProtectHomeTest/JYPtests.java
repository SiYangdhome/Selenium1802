package com.ProtectHomeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JYPtests {

    WebDriver driver;



    @BeforeMethod
    public void OpenBrowserTest(){
        /**
         * 打开浏览器、剧易拍网址
         * 输入用户名、密码，点击登录
         * 校验登录成功
         */
        System.setProperty("webdriver.chrome.driver","E:\\selenium_demo1802\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://p.moonpool.com.cn:8080/toLoginPage");
        driver.findElement(By.id("userName")).sendKeys("15010685335");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("submit")).click();
        String name = driver.findElement(By.id("usersName")).getText();

        Assert.assertEquals(name,"王建");

    }

    /**
     * 上传剧本
     *
     *
     */
    @Test
    public void UploadTest1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]/ul/li[1]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("uploadScriptBtn")).click();
        driver.switchTo().frame("uploadIframe");
        driver.findElement(By.xpath("//*[@id=\"firstWindow\"]/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"selectFileBtn\"]/div[2]//label")).sendKeys("C:\\Users\\Administrator\\Desktop\\第3集.docx");

    }


    /**
     * 角色表—— 高级搜索
     */
   @Test
   public void ReaSeachTest2() throws InterruptedException {
       WebElement element = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
       Actions actions = new Actions(driver);
       actions.moveToElement(element).perform();
       driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]/ul/li[2]/div")).click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"toolbar\"]/button[1]")).click();
       driver.findElement(By.id("queryViewRoleName")).sendKeys("穆青");
       driver.findElement(By.xpath("//*[@id=\"advanceSearchWin\"]/div/div/button[1]")).click();
       String text = driver.findElement(By.xpath("//*[@id=\"viewRoleListGrid\"]/tbody/tr[2]/td[2]/div/a")).getText();
       Assert.assertEquals(text,"穆青");
   }

    /**
     * 添加角色
     */
   @Test
   public void addrole3() throws InterruptedException {
       //定位拍摄管理
       WebElement element = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
       //实例化Actions类，调用actions方法将鼠标移动到拍摄按钮
       Actions actions = new Actions(driver);
       actions.moveToElement(element).perform();
       //定位角色表，并点击
       driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]/ul/li[2]/div")).click();
       Thread.sleep(3000);
       //以上代码为选择角色表

       //定位添加按钮，并点击
       driver.findElement(By.id("createRoleBtn")).click();
       //定位角色名称输入框，并输入“王者"
       driver.findElement(By.id("modifyViewRoleName")).sendKeys("王者");
       //定位角色类型，
       WebElement ele = driver.findElement(By.id("modifyViewRoleType"));
       ele.click();
       //实例化Select类，调用select中的方法，通过下标选择
       Select select = new Select(ele);
       select.selectByIndex(1);
       //定位并点击确定按钮
       driver.findElement(By.id("saveModifyRole")).click();
       Thread.sleep(3000);
       //获取新建角色的文本，并校验
       String rolename = driver.findElement(By.xpath("//*[@id=\"viewRoleListGrid\"]/tbody/tr[2]/td[2]/div/a")).getText();
       Assert.assertEquals(rolename,"王者");
   }

    /**
     * 统一角色名称
     */
   @Test
   public void SameRoleName4() throws InterruptedException {
       WebElement element = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]"));
       Actions actions = new Actions(driver);
       actions.moveToElement(element).perform();
       driver.findElement(By.xpath("//*[@id=\"navMenu\"]/li[1]/ul/li[2]/div")).click();
       Thread.sleep(5000);
       //以上代码为选择角色表
       driver.findElement(By.id("checkAll")).click();
       driver.findElement(By.id("makeRoleToOneBtn")).click();
       driver.findElement(By.id("makeViewRoleName")).sendKeys("王者荣耀");
       WebElement ele2 = driver.findElement(By.id("makeViewRoleType"));
       ele2.click();
       Select select = new Select(ele2);
       select.selectByIndex(1);
       driver.findElement(By.xpath("//*[@id=\"MakeRoleToOne\"]/div/ul/li[10]/div/button[1]")).click();
       Thread.sleep(3000);
       String rolename = driver.findElement(By.xpath("//*[@id=\"viewRoleListGrid\"]/tbody/tr[2]/td[2]/div/a")).getText();
       Assert.assertEquals(rolename,"王者荣耀");




   }
    @AfterMethod
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
