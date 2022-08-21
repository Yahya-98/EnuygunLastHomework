import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroceryApiTest {

    GroceryApi gApi = new GroceryApi();

    @Test
    public void allGrocery() throws UnirestException {
        Assert.assertEquals(gApi.allGrocery(),200);
    }

    @Test
    public void getGrocery() throws UnirestException {
        Assert.assertEquals(gApi.getGrocery(),200);
    }
    @Test
    public void addGrocery() throws UnirestException {
        Assert.assertEquals(gApi.postGrocery(),200);
    }
}
