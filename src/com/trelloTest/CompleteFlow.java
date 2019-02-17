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
            System.out.println("Create new board: OK");
        } else {
            driver.quit();
            System.exit(0);
        }
        
        //create new list
        driver.insertText("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/input", "My new list");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div/form/div/input");
        System.out.println("Create new list: OK");
        
        //create new card
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div[1]/a/span[2]");
        driver.insertText("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div[1]/div/textarea", "My test card");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/input");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div[1]/div[2]/a/div[3]/span");
        
        //create card label
        driver.insertText("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[2]/div[2]/div/div/div[3]/textarea", "Some description.");
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[2]/div[2]/div/div/div[3]/div/input");
        
        //add comment
        driver.insertText("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[9]/div[2]/form/div[1]/div/textarea", "Some comment\n");
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[9]/div[2]/form/div[2]/input");
        
        //add image
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[9]/div[2]/form/div[1]/div/div/a[1]/span");
        driver.insertText("//*[@id='addLink']", "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input[2]");
        
        //create first checkbox
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[6]/div[1]/div/a[3]");
        driver.insertText("//*[@id=\"id-checklist\"]", "First item");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/form/input[2]");
        
        //create second checkbox
        driver.insertText("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[8]/div/div[4]/textarea", "Second item");
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[8]/div/div[4]/div/input");
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/div/div[5]/div[8]/div/div[4]/div/a[1]");
        
        driver.click("/html/body/div[2]/div[2]/div[3]/div/div/a");
        
        
        //delete board and set on home page
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[1]/li[4]/a");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/ul[3]/li/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        driver.click("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/p[2]/a");
        driver.click("/html/body/div[2]/div[2]/div[4]/div/div[2]/div/div/div/input");
        driver.setHomePage(homePage);
        
        //quit chrome driver
        driver.quit();
    }

}
