package com.autotest.selenium.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class emailTest {

    @Test
    public  void test01() throws InterruptedException {
        //设置浏览器路径
        System.setProperty("webdriver.firefox.bin", "D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mail.163.com");





    }

}
