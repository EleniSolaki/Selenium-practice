package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class mySelenium {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.drive","C:/Users/eleni/IdeaProjects/Selenium2/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        //driver.wait(3000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://tutorialsninja.com/demo/index.php"); //opens the url

        driver.manage().window().maximize(); //maximize the browser
//        int count = driver.findElements(By.tagName("a")).size();
//        System.out.println(count);

        driver.findElement(By.name("search")).click(); //click the search field
        //Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("MacBook"); //type "McBook" in input
        Thread.sleep(1000);
        driver.findElement(By.className("input-group-btn")).click(); //find and click search button
        Thread.sleep(3000);
        //driver.findElement(By.linkText("MacBook")).click(); // find and click with "a"
        //Xpath (//Tagname[@attribute='value'])
        driver.findElement(By.xpath("//img[@alt='MacBook']")).click(); //click to mcbook product
        Thread.sleep(2000);
        driver.findElement(By.id("input-quantity")).clear(); //clearing the default quantity
        Thread.sleep(500);
        driver.findElement(By.id("input-quantity")).sendKeys("2");
        Thread.sleep(1000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("alert-success")).getText();
        String txt = driver.findElement(By.className("alert-success")).getText();
        System.out.println(txt);
        Assert.assertEquals(txt, "Success: You have added MacBook to your shopping cart!\n×");
        // Assert.assertEquals(txt,"Success: You have added MacBook to your shopping cart!\n ×");
        //Assert.assertEquals(alert,"Success: You have added MacBook to your shopping cart!\n×");
        //options.setImplicitWaitTimeout(Duration.of(10L, ChronoUnit.MINUTES));
        Thread.sleep(3000);
        driver.close();

    }
}
