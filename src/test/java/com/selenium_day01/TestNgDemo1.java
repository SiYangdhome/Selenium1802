package com.selenium_day01;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgDemo1 {


    @BeforeTest
    public void Test1(){
        System.out.println("BeforeTest注解，最先执行且只执行一次");
    }

    @BeforeMethod
    public void Test2(){
        System.out.println("每个case执行前都要执行一次");
    }

    @Test
    public void testCase1(){
        System.out.println("Hello,World!");
        String a = "Hello,World!";
        String b = "Hello,World!";
        Assert.assertEquals(a,b);
    }

    @Test
    public void testCase2(){
        System.out.println("welcome to China");
    }

    @AfterMethod
    public void closeCase(){
        System.out.println("每个case执行完后都要执行一次");
    }

    @AfterTest
    public void closeBrowser(){
        System.out.println("关闭浏览器，所有用例执行完以后执行一次");
    }
}
