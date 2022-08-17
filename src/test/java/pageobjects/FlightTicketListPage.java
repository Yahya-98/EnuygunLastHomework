package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriverSetup.DriverSetup;
import java.time.Duration;



public class FlightTicketListPage {


    DriverSetup driver;

    public FlightTicketListPage(DriverSetup driver){
        this.driver = driver;
    }
    String url;
   // By opticket = By.xpath("//div[@data-booking-provider=\"sabre\"]");
    By fly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/label/div[1]");
    By returnFly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/label/div[2]");
    By tl = By.xpath("//button[@id=\"tooltipTarget_0\"]");
    By selectBtn = By.xpath("//button[@id=\"tooltipTarget_0\"]");



    public void ticketselect() {

        driver.getWait().until(ExpectedConditions.presenceOfElementLocated(fly));
        driver.element().findElement(fly).click();

    }

    public boolean setReturnFly(){
        driver.getWait().until(ExpectedConditions.elementToBeClickable(returnFly));
        driver.element().findElement(returnFly).click();
        url = driver.element().getCurrentUrl();
        return driver.element().findElement(returnFly).isSelected();
    }

    public String okbtn(){
        driver.getWait().withTimeout(Duration.ofSeconds(1L));
        driver.getWait().until(ExpectedConditions.elementToBeClickable(selectBtn));
        driver.element().findElement(selectBtn).click();

        return url;
    }

}
