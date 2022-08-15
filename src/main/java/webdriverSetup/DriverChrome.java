package webdriverSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;


public class DriverChrome extends DriverSetup{

    static Map data;

    public WebDriver element(){
        return driver;
    }

    public DriverChrome(){
        openUrl();
    }

    @Override
    public void openUrl() {
        data = ConfigReader.dataProperties();
        //Chrome options for notification and popup blocking
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized"); // start chrome maximized
        options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //removes the banner

        //this line created the chromedriver
        try{
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver(options);

        }catch (SessionNotCreatedException e){
            System.out.println("\nWeb Driver Not Created " + e.getMessage());
        }catch (IllegalStateException e){
            System.out.println("\nWeb Driver Not Found" + e.getMessage());
        }
        String url = String.valueOf(data.get("url")); // get url from resources/config
        super.openUrl();
        // this line for get url
        driver.get(url);

    }

}
