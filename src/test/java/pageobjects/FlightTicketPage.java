package pageobjects;


import org.openqa.selenium.By;
import webdriverSetup.ConfigReader;
import webdriverSetup.DriverChrome;
import webdriverSetup.DriverSetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FlightTicketPage {


    DriverSetup driver = new DriverChrome();

    public static Map data;


    By origin = By.id("OriginInput"); // nereden
    By destination = By.id("DestinationInput"); //nereye
    By idDirect = By.id("transitFilter");
    By originFirst = By.id("react-autowhatever-OriginInput-section-0-item-0"); // select the first origin
    By destinationFirst = By.id("react-autowhatever-DestinationInput-section-0-item-0"); // select the first destination
    By originDateBar = By.id("DepartureDate");
    //By originDate = By.xpath("//td[@aria-label=\""+ date1 + "\"]");

    //td[@aria-label="Pazartesi, 15 Ağustos 2022"]

    public FlightTicketPage(){
        data = ConfigReader.dataProperties();

    }



    public void flightTicket(){
        driver.element().findElement(origin).sendKeys(String.valueOf(data.get("origin")));
        driver.element().findElement(originFirst).click();
        driver.element().findElement(destination).sendKeys(String.valueOf(data.get("destination")));
        int desti =Integer.parseInt(String.valueOf(data.get("departureDay")));
        String s = date(desti);
        driver.element().findElement(destinationFirst).click();
        driver.element().findElement(originDateBar).click();
       // driver.element().findElement(originDate).click();
      //  departureDay  returnDay

    }

    public String date (int addDay){
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date(new Date().getTime() + 86400000L * addDay); // one day 1000 * 60 * 60 * 24 = 86400000
        String  date2 = dateFormat.format(date);
        return dateFormat.format(date);
    }




}
