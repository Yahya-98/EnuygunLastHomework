
import apiobjects.SwaggerPetstoreApi;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SwaggerPetstoreApiTest {

    SwaggerPetstoreApi swaggerPetstoreApi = new SwaggerPetstoreApi();
    JsonPath jp;
    @Test(priority = 1, description = "Status available check")
    public void statusAvailableTest()  {

        Assert.assertEquals(swaggerPetstoreApi.getRequest("findByStatus?status=available").statusCode(),200);

    }

    @Test(priority = 2, description = "Status pending check")
    public void statusPendingTest(){

        Assert.assertEquals(swaggerPetstoreApi.getRequest("findByStatus?status=pending").statusCode(),200);
    }

    @Test(priority = 3, description = "Status sold check")
    public void statusSoldTest(){

        Assert.assertEquals(swaggerPetstoreApi.getRequest("findByStatus?status=sold").statusCode(),200);
    }
    @Test(priority = 4, description = "Get id check from third available pet")
    public void apiGetidStatusCheck(){
        Assert.assertEquals(swaggerPetstoreApi.apiGetidStatusCheck("available",2),true);
    }

    @Test(priority = 5, description = "Post update pet name and status")
    public void postPetIdTest() throws UnirestException {
        Assert.assertEquals(swaggerPetstoreApi.apiPostRequest("newpetname","available"),200);
    }
    @Test(priority = 6, description = "Delete pet and check")
    public void deletePetTest(){

        jp = swaggerPetstoreApi.getRequest("findByStatus?status=available").jsonPath();
        String id = String.valueOf(jp.getList("id").get(5));

        Assert.assertEquals(swaggerPetstoreApi.apiDeleteRequest(id).statusCode(),200);
    }

}
