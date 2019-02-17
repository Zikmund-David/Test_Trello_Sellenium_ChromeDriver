package com.trelloTest;

/**
 *
 * @author David Zikmund
 */
public class NewList {

    /**
     * Test create new list
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String homePage = "https://trello.com";
        String driverPath = "src//com//trelloTest//chromedriver.exe";
        
        //create instance help class SelleniumWebDriver
        SelleniumWebDriver driver = new SelleniumWebDriver(driverPath, homePage);
        
        System.out.println("TEST REQUEST:");
        
        //login
        driver.click("/html/body/div[1]/div[2]/a[1]");
        driver.insertText("//*[@id=\'user\']", "zikmund-david@seznam.cz");
        driver.insertText("//*[@id=\'password\']", "12345678910");
        driver.click("//*[@id=\'login\']");
        
        //wait for login
        if(driver.waitFor("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a", 10)) {
            System.out.println("Login: OK");
        } else {
            driver.quit();
            System.exit(0);
        }
        
        //find board
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/ul/li[1]/div/a/span[2]/span");
        
        //wait for load
        if(driver.waitFor("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/a/span", 10)) {
            System.out.println("Load: OK");
        } else {
            driver.quit();
            System.exit(0);
        }
        
        //create new list
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/a/span");
        driver.insertText("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/input", "New_test_list");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/div/input");
        System.out.println("Create new list: OK");
    }

}
