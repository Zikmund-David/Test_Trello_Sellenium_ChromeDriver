package com.trelloTest;

/**
 *
 * @author David Zikmund
 */
public class NewBoard {

    /**
     * Test add new board
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

        //new board
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div/a[1]");
        
        //set background
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/ul/li[3]/button");

        //set boardname
        driver.insertText("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[1]/input", "My_Test_Board");

        //set board private
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[2]/button");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/ul/li[1]/a");
        
        //create board
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/button/span[2]");
        
        //wait for create new board
        if(driver.waitFor("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a", 100)) {
            System.out.println("Create new board: OK");
        } else {
            driver.quit();
            System.exit(0);
        }
        
        System.out.println("Test: OK");
        
        //delete board and set on home page
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[3]/li/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/p[2]/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        driver.setHomePage(homePage);
    }

}
