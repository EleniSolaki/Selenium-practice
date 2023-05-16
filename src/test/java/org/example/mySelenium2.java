package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class mySelenium2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.drive","C:/Users/eleni/IdeaProjects/Selenium2/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url); //opens the url

        driver.manage().window().maximize(); //maximize the browser
        Thread.sleep(2000);

        boolean selected = driver.findElement(By.id("checkBoxOption2")).isSelected();
        System.out.println(selected);


       // System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());
        //driver.findElement(By.id("checkBoxOption2")).click();
        //System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());

        int count = driver.findElements(By.tagName("a")).size();
        System.out.println(count);

        //Xpath (//Tagname[@attribute='value'])
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()); //determine how many checkboxes there are

        //find alert button
        driver.findElement(By.id("name")).sendKeys("Eleni");
        driver.findElement(By.id("alertbtn")).click();
        String alertmsg = driver.switchTo().alert().getText();
        System.out.println(alertmsg);
        String exp = "Hello Eleni, share this practice page and share your knowledge";
        Assert.assertEquals(alertmsg,exp);


    }
}
