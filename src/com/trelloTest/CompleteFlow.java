package com.trelloTest;

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
        String homePage = "https://trello.com";
        String driverPath = "src//com//trelloTest//chromedriver.exe";
        
        SelleniumWebDriver driver = new SelleniumWebDriver(driverPath, homePage);
        
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

        //set blue background
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/ul/li[5]/button");

        //set boardname
        driver.insertText("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[1]/input", "New_Board_CompleteFlow");

        //set board private
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/div/div/div[2]/button");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/ul/li[1]/a");
        
        //create board
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/form/button/span[2]");
        
        //wait for create new board
        if(driver.waitFor("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a", 100)) {
            System.out.println("Create: OK");
        } else {
            driver.quit();
            System.exit(0);
        }

        //delete board
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[3]/li/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/p[2]/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        
        //wait for delete
        if(driver.waitFor("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a/span", 100)) {
            System.out.println("Delete: OK");
        } else {
            driver.quit();
            System.exit(0);
        }
        driver.setHomePage(homePage);
        //driver.quit();
    }

}
