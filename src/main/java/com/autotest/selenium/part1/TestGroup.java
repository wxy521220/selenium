package com.autotest.selenium.part1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class TestGroup {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        WebElement search_text = driver.findElement(By.id("kw"));
        search_text.sendKeys("selenium");
        search_text.submit();
        Thread.sleep(2000);

        //匹配第一页搜索结果的标题， 循环打印  *表示通配符，该标签下的所有元素
        List<WebElement> search_result = driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[1]/div[3]/*"));


        //打印元素的个数
        System.out.println(search_result.size());

        // 循环打印搜索结果的标题
        for(WebElement result : search_result){
            System.out.println(result.getText());
            System.out.println("111111");
        }

        System.out.println("-------我是分割线---------");

        driver.quit();
    }
}