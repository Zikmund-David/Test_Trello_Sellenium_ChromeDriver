package com.trelloTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author David Zikmund
 */
public class SelleniumWebDriver {
    private WebDriver driver = null;
    
    //set chrome driver
    private void setChromeDriver(String path) {
        System.setProperty("webdriver.chrome.driver", path);
    }
    
    //set home page
    public void setHomePage(String homePage) {
        driver.get(homePage);
    }

    //Constructor for class SelleniumWebDriver
    public SelleniumWebDriver(String driverPath, String homePage) {
        try {
            this.setChromeDriver(driverPath);
            driver = new ChromeDriver();
            this.setHomePage(homePage);
        } catch(Exception e) {
            System.out.println("Error1: " + e);
            System.exit(0);
        }
    }
    
    //click on component (by xpath)
    public void click(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            System.out.println("Error: (click)" + e);
            System.exit(0);
        }
    }
    
    //insert text into component (by xpath)
    public void insertText(String xpath, String text) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(text);
        } catch (Exception e) {
            System.out.println("Error (insert text): " + e);
            System.exit(0);
        }
    }
    
    //wait for load by visibility components
    public boolean waitFor(String componentPath, int time) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(componentPath)));
            boolean status = element.isDisplayed();
            if(status) {
                result = true;
            } else {
                System.out.println("Undefined error.");
            }
            
        } catch(Exception e) {
            System.out.println("Error (wait): " + e);
            result = false;
        }
        return result;
    }
    
    //quit chrome driver
    public void quit() {
        driver.quit();
    }
}
