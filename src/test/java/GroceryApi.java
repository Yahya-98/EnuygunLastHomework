import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class GroceryApi {

    Response response;
    public GroceryApi(){
        baseURI = "https://95add92b-a97b-49f7-9896-b4b1517b682f.mock.pstmn.io//allGrocery/";

    }

    public int allGrocery() throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseURI)
                .asString();

        return response.getStatus();
    }

    public int getGrocery() throws UnirestException{
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get(baseURI + "apple")

                .asString();

        return response.getStatus();


    }

    public int postGrocery() throws UnirestException{
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://95add92b-a97b-49f7-9896-b4b1517b682f.mock.pstmn.io//add")
                .body("")
                .asString();
        return response.getStatus();
    }
}
