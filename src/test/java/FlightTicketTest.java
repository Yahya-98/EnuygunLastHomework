
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.FlightTicketListPage;
import pageobjects.FlightTicketPage;
import webdriverSetup.DriverChrome;
import webdriverSetup.DriverSetup;

public class FlightTicketTest {

    FlightTicketPage homePage;
    FlightTicketListPage ticketpage;
    static DriverSetup driver;

    @BeforeClass
    public void setup(){
        driver = new DriverChrome();
        homePage = new FlightTicketPage(driver);
        ticketpage = new FlightTicketListPage(driver);


    }
    @Test(priority = 1,description = "Add origin,destination departureday and return day ")
    public void start()  {
        homePage.flightTicket();
        Assert.assertNotEquals(driver.element().getCurrentUrl(),"https://www.enuygun.com/ucak-bileti/");
    }
    @Test(priority = 2, description = "Select departure ticket")
    public void selectDepartureTicket()  {
        ticketpage.setDepartureFly();

    }

    @Test(priority = 3,description = "Select return ticket")
    public void selectReturnTicket() throws InterruptedException {

        Assert.assertNotEquals(ticketpage.setReturnFly(),"true");

    }

    @Test(priority = 4,description = "Departure and return ticked selecten click the select button")
    public void finishSelectTicket() throws InterruptedException{
        String url = ticketpage.selectFly();
        Assert.assertNotEquals(driver.element().getCurrentUrl(),url);
    }
}
