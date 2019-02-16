package com.trelloTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author David Zikmund
 */
public class CompleteFlow {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src//com//trelloTest//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://trello.com");
        
        //test:
        //login
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\'user\']")).sendKeys("zikmunddavid.dz@gmail.com");
        driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("zIKMUNDd123456");
        driver.findElement(By.xpath("//*[@id=\'login\']")).click();
        
        //wait for login
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a")));
            boolean status = element.isDisplayed();
            if(status) {
                System.out.println("Element is displayed.");
            }
            
        } catch(Exception e) {
            System.out.println("Failure: " + e);
            driver.quit();
            System.exit(0);
        }
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[1]/input")).click();
        System.out.println("Everythink is ok.");
        //driver.quit();
    }

}
