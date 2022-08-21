
import org.testng.Assert;
import org.testng.annotations.Test;



public class ApiTest {
    Api api = new Api();
    @Test
    public void statusAvailableTest()  {

        Assert.assertEquals(api.getRequest("findByStatus?status=available"),200);
    }

    @Test
    public void statusPendingTest(){

        Assert.assertEquals(api.getRequest("findByStatus?status=pending"),200);
    }

    @Test
    public void statusSoldTest(){

        Assert.assertEquals(api.getRequest("findByStatus?status=sold"),200);
    }
    @Test
    public void Check(){
        api.apiGetidStatusCheck(12);
    }


}
