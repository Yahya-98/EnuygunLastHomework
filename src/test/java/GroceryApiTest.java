import apiobjects.GroceryApi;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroceryApiTest {

    GroceryApi gApi = new GroceryApi();

    @Test(priority = 1 , description = "Get all grocery")
    public void allGrocery() throws UnirestException {
        Assert.assertEquals(gApi.allGrocery(),200);
    }

    @Test(priority = 2, description = "Get info for name")
    public void getGrocery() throws UnirestException {
        Assert.assertEquals(gApi.getGrocery(),200);
    }
    @Test(priority = 3, description = "Add grocery")
    public void addGrocery() throws UnirestException {
        Assert.assertEquals(gApi.postGrocery(),200);
    }
}
