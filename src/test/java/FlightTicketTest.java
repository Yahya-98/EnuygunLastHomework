
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
    @Test
    public void start(){
        homePage.flightTicket();
        ticketpage.ticketselect();

    }

}
