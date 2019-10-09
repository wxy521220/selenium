package com.autotest.selenium.part1;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class TestGroup  {

    @Test
    public  void test01() throws InterruptedException {
        //设置浏览器路径
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

        //关闭当前窗口
        //driver.close();
        //关闭所有窗口并且退出浏览器，尽量使用quit
        driver.quit();
    }

    /*
    设置浏览器的大小
     */

    @Test
    public  void test02() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        //设置浏览器为最大的宽高
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.get("https://www.baidu.com");
        //设置浏览器的宽高
        driver.manage().window().setSize(new Dimension(480,800));
        Thread.sleep(2000);

        driver.quit();
    }

    /*
    控制浏览器前进、后退
     */
    @Test
    public  void test03() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        WebElement search_text = driver.findElement(By.id("kw"));
        search_text.sendKeys("selenium");
        search_text.submit();
        Thread.sleep(2000);


        //控制浏览器后退
        driver.navigate().back();
        Thread.sleep(2000);
        //driver.getCurrentUrl():获取当前的url
        System.out.println("back url:"+driver.getCurrentUrl());

        //控制浏览器前进
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println("forward url:"+driver.getCurrentUrl());

        //控制浏览器前进
        driver.navigate().refresh();
        System.out.println("我刷新了");

        driver.quit();
    }

    /*
    常用方法
     */
    @Test
    public  void test04() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        WebElement search_text = driver.findElement(By.id("kw"));
        WebElement search_button = driver.findElement(By.id("su"));
        search_text.sendKeys("selenium");
        Thread.sleep(4000);
        search_text.submit();
        Thread.sleep(4000);


        //clear()清除文本
        search_text.clear();
        Thread.sleep(2000);

        search_text.sendKeys("testng");
        search_button.click();
        Thread.sleep(2000);

        driver.quit();
    }
    /*
    常用方法
     */
    @Test
    public  void test05() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        //获得百度输入框的尺寸
        WebElement size = driver.findElement(By.id("kw"));
        System.out.println(size.getSize());

        //返回百度页面底部备案信息
        WebElement text = driver.findElement(By.id("cp"));
        //getText()：获取当前的文本信息
        System.out.println(text.getText());

        //返回元素的属性值， 可以是 id、 name、 type 或元素拥有的其它任意属性
        WebElement ty = driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("type"));

        //返回元素的结果是否可见， 返回结果为 True 或 False
        WebElement display = driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());


        driver.quit();
    }
    /*
    contextClick() 右击
    clickAndHold() 鼠标点击并控制
    doubleClick() 双击
    dragAndDrop(A,B) 拖动,将元素A拖动至元素B的位置
    release() 释放鼠标
    perform() 执行所有Actions中存储的行为
     */
    @Test
    public  void test06() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        WebElement search_setting = driver.findElement(By.linkText("设置"));

        Thread.sleep(2000);
        Actions action = new Actions(driver);

        //clickAndHold() 鼠标点击并控制
        //perform() 执行所有Actions中存储的行为
        action.clickAndHold(search_setting).perform();
        WebElement search_setting2 = driver.findElement(By.linkText("搜索设置"));
        search_setting2.click();
        Thread.sleep(2000);

        driver.quit();
    }
    /*
    模拟键盘组合键使用:在使用键盘按键方法前需要先导入 keys 类。
     */
    @Test
    public  void test07() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        WebElement input = driver.findElement(By.id("kw"));

        //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);

        //删除多输入的一个 m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        //输入空格键+“教程”
        input.sendKeys(Keys.TAB);
        input.sendKeys("教程");
        Thread.sleep(2000);

        //ctrl+a 全选输入框内容
        input.sendKeys(Keys.CONTROL,"a");
        Thread.sleep(2000);

        //ctrl+x 剪切输入框内容
        input.sendKeys(Keys.CONTROL,"x");
        Thread.sleep(2000);

        //ctrl+v 粘贴内容到输入框
        input.sendKeys(Keys.CONTROL,"v");
        Thread.sleep(2000);

        //通过回车键盘来代替点击操作
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();
    }
    /*
    多表单切换
     */
    @Test
    public  void test08() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.126.com");

        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();

    }
    /*
    多表单切换
     */
    @Test
    public  void test09() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        //获得当前窗口句柄
        String search_handle = driver.getWindowHandle();
        Thread.sleep(5000);

        //打开百度注册窗口
        driver.findElement(By.linkText("登录")).click();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        Thread.sleep(10000);

        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df1.format(new Date()));// new Date()为获取当前系统时间

        driver.findElement(By.linkText("立即注册")).click();

        //获得所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //判断是否为注册窗口， 并操作注册窗口上的元素
        for(String handle : handles){
            if (handle.equals(search_handle)==false){
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("now register window!");
                Thread.sleep(10000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("user name");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("phone number");
                //......
                Thread.sleep(10000);
                //关闭当前窗口
                driver.close();
            }
        }
        Thread.sleep(2000);

        driver.quit();

    }
    /*
    多表单切换
     */
    @Test
    public  void test10() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");

        driver.findElement(By.linkText("设置")).click();
        driver.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(2000);

        //<select>标签的下拉框选择
        WebElement el = driver.findElement(By.xpath("//select"));
        Select sel = new Select(el);
        sel.selectByValue("20");
        Thread.sleep(2000);

        driver.quit();

    }
    /*
    调用JavaScript代码
     */
    @Test
    public  void test11() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","D:\\software\\firefox\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();

        //设置浏览器窗口大小
        driver.manage().window().setSize(new Dimension(700, 600));
        driver.get("https://www.baidu.com");


        //进行百度搜索
        driver.findElement(By.id("kw")).sendKeys("webdriver api");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);


        //将页面滚动条拖到底部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);


        driver.quit();
    }


}