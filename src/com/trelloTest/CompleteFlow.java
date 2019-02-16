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
     * Test complete flow.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //add ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src//com//trelloTest//chromedriver.exe");
        
        //create new instance chromedriver
        WebDriver driver = new ChromeDriver();
        
        //set home page
        driver.get("https://trello.com");
        
        //login
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\'user\']")).sendKeys("zikmund-david@seznam.cz");
        driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys("12345678910");
        driver.findElement(By.xpath("//*[@id=\'login\']")).click();
        
        //wait for login
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a")));
            boolean status = element.isDisplayed();
            if(status) {
                System.out.println("Login ok.");
            }
            
        } catch(Exception e) {
            System.out.println("Failure: " + e);
            driver.quit();
            System.exit(0);
        }
        
        //new board
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/a[1]")).click();
        
        //set blue background
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/ul/li[5]/button")).click();
        
        //set boardname
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[1]/input")).sendKeys("New_Board_CompleteFlow");
        
        //set board private
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/ul/li[1]/a")).click();
        
        //create board
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/form/button/span[2]")).click();
        System.out.println("Create board ok.");
        
        //wait for create new board
        try {
            WebDriverWait wait = new WebDriverWait(driver, 100);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a")));
            boolean status = element.isDisplayed();
            if(status) {
                System.out.println("Create ok.");
            }
            
        } catch(Exception e) {
            System.out.println("Failure: " + e);
            driver.quit();
            System.exit(0);
        }
        
        //delete board
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[3]/li/a")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/p[2]/a")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input")).click();
        } catch (Exception e) {
            System.out.println("Failure: " + e);
            driver.quit();
            System.exit(0);
        }
        System.out.println("Delete board ok.");
        
        System.out.println("Everythink is ok.");
        //driver.quit();
    }

}
