
import org.testng.annotations.Test;
import pageobjects.FlightTicketPage;


public class FlightTicketTest {

    FlightTicketPage homePage = new FlightTicketPage();


    @Test
    public void start(){
        homePage.flightTicket();

    }

}
