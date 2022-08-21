
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ApiTest {
    Api api = new Api();
    JsonPath jp;
    @Test
    public void statusAvailableTest()  {

        Assert.assertEquals(api.getRequest("findByStatus?status=available").statusCode(),200);

    }

    @Test
    public void statusPendingTest(){

        Assert.assertEquals(api.getRequest("findByStatus?status=pending").statusCode(),200);
    }

    @Test
    public void statusSoldTest(){

        Assert.assertEquals(api.getRequest("findByStatus?status=sold").statusCode(),200);
    }
    @Test
    public void Check(){
        Assert.assertEquals(api.apiGetidStatusCheck("available",2),true);
    }

    @Test
    public void postPetIdTest() throws UnirestException {
        Assert.assertEquals(api.apiPostRequest("newpetname","available"),200);
    }
    @Test
    public void deletePetTest(){

        jp = api.getRequest("findByStatus?status=available").jsonPath();
        String id = String.valueOf(jp.getList("id").get(5));

        Assert.assertEquals(api.apiDeleteRequest(id).statusCode(),200);
    }

}
