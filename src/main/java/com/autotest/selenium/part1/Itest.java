package com.autotest.selenium.part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Itest {
    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        String title = driver.getTitle();
        System.out.printf(title);
        WebElement search_text=((FirefoxDriver) driver).findElementById("kw");
        WebElement search_button=((FirefoxDriver) driver).findElementById("su");

        search_text.sendKeys("百度");
        //清空输入框内容
        search_text.clear();
        //输入框输入内容
        search_text.sendKeys("selenium");
        //单击
        search_button.click();

        //driver.quit();

        //获得百度输入框的尺寸
        WebElement size = driver.findElement(By.id("kw"));
        System.out.println(size.getSize());

        //返回百度页面底部备案信息
        WebElement text = driver.findElement(By.id("cp"));
        System.out.println(text.getText());

        //返回元素的属性值， 可以是 id、 name、 type 或元素拥有的其它任意属性
        WebElement ty = driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("type"));

        //返回元素的结果是否可见， 返回结果为 True 或 False
        WebElement display = driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());


        WebElement search_setting = driver.findElement(By.linkText("设置"));
        Actions action = new Actions(driver);
        action.clickAndHold(search_setting).perform();
        //driver.close();
        //driver.quit();
    }
}