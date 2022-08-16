package pageobjects;


import org.openqa.selenium.By;
import webdriverSetup.DriverSetup;
import java.time.Duration;


public class FlightTicketListPage {


    DriverSetup driver;

    public FlightTicketListPage(DriverSetup driver){
        this.driver = driver;
    }
    By opticket = By.xpath("//div[@data-booking-provider=\"sabre\"]");
    By fly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/label/div[1]");
    By returnFly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/label/div[2]");
    By tl = By.xpath("//button[@id=\"tooltipTarget_0\"]");

    public void ticketselect(){

        driver.element().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.element().findElement(fly).click();
        driver.element().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.element().findElement(returnFly).click();



       // driver.element().findElement(opticket).click();

    }



}
