
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
    @Test(priority = 1)
    public void start()  {
        homePage.flightTicket();
        Assert.assertNotEquals(driver.element().getCurrentUrl(),"https://www.enuygun.com/ucak-bileti/");
    }
    @Test(priority = 2)
    public void retur()  {
        ticketpage.setDepartureFly();

    }

    @Test(priority = 3)
    public void s1() throws InterruptedException {

        Assert.assertNotEquals(ticketpage.setReturnFly(),"true");

    }

    @Test(priority = 4)
    public void select() throws InterruptedException{
        String url = ticketpage.selectFly();
        Assert.assertNotEquals(driver.element().getCurrentUrl(),url);
    }
}
