package pageobjects;


import org.openqa.selenium.By;
import webdriverSetup.ConfigReader;
import webdriverSetup.DriverSetup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class FlightTicketPage {



    DriverSetup driver;

    public static Map data;


    By origin = By.id("OriginInput"); // nereden
    By destination = By.id("DestinationInput"); //nereye
    By isDirect = By.id("transitFilter");
    By originFirst = By.id("react-autowhatever-OriginInput-section-0-item-0"); // select the first origin
    By destinationFirst = By.id("react-autowhatever-DestinationInput-section-0-item-0"); // select the first destination
    By originDateBar = By.id("DepartureDate");
    By nextMonthBtn = By.xpath("//div[@aria-label=\"Move forward to switch to the next month.\"]");
    By returnDate = By.id("ReturnDate");
    By findTicketBtn = By.xpath("//button[@class=\"primary-btn block\"]");

    public FlightTicketPage(DriverSetup driver){

        this.driver =driver;
        data = ConfigReader.dataProperties();

    }



    public void flightTicket(){
        driver.element().findElement(origin).sendKeys(String.valueOf(data.get("origin")));
        driver.element().findElement(originFirst).click();
        driver.element().findElement(destination).sendKeys(String.valueOf(data.get("destination")));
        driver.element().findElement(destinationFirst).click();
        driver.element().findElement(originDateBar).click();
        String ticketDate = datefinder(Integer.parseInt(String.valueOf(data.get("departureDay"))));

        By departureDay = By.xpath("//td[@aria-label=\""+ ticketDate + "\"]");
        if(String.valueOf(data.get("departureDay")).equals("1")){
            By departureDay1 = By.xpath("//td[@aria-label=\""+ "Selected. " + ticketDate + "\"]");
            driver.element().findElement(departureDay1).click();
        }else{
            driver.element().findElement(departureDay).click();
        }
        driver.element().findElement(returnDate).click();
        String ticketReturnDay = datefinder(Integer.parseInt(String.valueOf(data.get("departureDay"))) + Integer.parseInt(String.valueOf(data.get("returnDay"))));
        driver.element().findElement(returnDay(ticketReturnDay,ticketDate)).click();
        if(String.valueOf(data.get("isDirect")).toLowerCase().equals("true")){driver.element().findElement(isDirect).click();} // if isdirect true select direct flight
        driver.element().findElement(findTicketBtn).click();



    }
    // if return day equals the departure day element changed this function check the element and fix it
    private By returnDay(String ticketReturnDay, String  departureDay){
        if(ticketReturnDay.equals(departureDay)){
            return By.xpath("//td[@aria-label=\""+"Selected. " + ticketReturnDay + "\"]");
        }else{
            return By.xpath("//td[@aria-label=\""+ ticketReturnDay + "\"]");}
    }

    private String  datefinder (int addDay){
        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Date date = new Date(new Date().getTime() + 86400000L * addDay); // one day 1000 * 60 * 60 * 24 = 86400000
        String  ticketDate = dateFormat.format(date);

        // this line check expected month next month or far
        DateFormat monthFormat = new SimpleDateFormat("MM");
        Date currentMonth = new Date();
        int currentMonthint = Integer.parseInt(monthFormat.format(currentMonth));
        Date expectedMonth = new Date(new Date().getTime() + 86400000L * addDay); // one day 1000 * 60 * 60 * 24 = 86400000
        int expectedMonthint = Integer.parseInt(monthFormat.format(expectedMonth));
        // if ticket month not this mont or next month find the ticket month
        if ((expectedMonthint - currentMonthint) >= 2) {
            for(int i = 0; i <(expectedMonthint - currentMonthint) - 1; i++){
                driver.element().findElement(nextMonthBtn).click();
            }
        }
        return ticketDate;
        }





    }
