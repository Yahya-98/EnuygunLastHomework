package webdriverSetup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DriverSetup  {

    static WebDriver driver;
    WebDriverWait wait;


    public DriverSetup(){
    }


    public void openUrl(){
    }

    public  WebDriver element(){

        return driver;
    }

    public WebDriverWait getWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;

    }

}
