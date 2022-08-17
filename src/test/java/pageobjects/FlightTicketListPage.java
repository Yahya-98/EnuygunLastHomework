
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriverSetup.DriverSetup;

public class FlightTicketListPage {


    DriverSetup driver;

    public FlightTicketListPage(DriverSetup driver){
        this.driver = driver;
    }
    String url;
    By departureFly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/label/div[1]");
    By returnFly = By.xpath("//*[@id=\"SearchRoot\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/label/div[2]");
    By selectBtn = By.xpath("//button[@id=\"tooltipTarget_0\"]");
    By payBtn = By.xpath("//button[@class=\" btn btn-success btn-lg tr  js-reservation-btn\"]");



    public void setDepartureFly() {

        driver.getWait().until(ExpectedConditions.presenceOfElementLocated(departureFly));
        driver.element().findElement(departureFly).click();

    }

    public boolean setReturnFly() throws InterruptedException{
        Thread.sleep(3000);
        driver.element().findElement(returnFly).click();
        return driver.element().findElement(returnFly).isSelected();
    }

    public String selectFly() throws InterruptedException{
        Thread.sleep(1000);
        url = driver.element().getCurrentUrl();
        driver.element().findElement(selectBtn).click();
        driver.getWait().until(ExpectedConditions.presenceOfElementLocated(payBtn));
        return url;
    }

}
