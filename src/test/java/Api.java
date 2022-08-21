
import com.github.javafaker.Faker;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Api {
    Response response;
    JsonPath jp;
    Faker faker;

   public Api(){

       baseURI = "https://petstore.swagger.io/v2/pet/";
   }

    public Response getRequest(String requestUrl){
        response = given()
                .header("content-type","application/json")
                .when()
                .get(requestUrl)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();
        return response;
    }

    public boolean apiGetidStatusCheck(String status,int index){

       jp = getRequest("findByStatus?status=" + status).jsonPath();
       String id = String.valueOf(jp.getList("id").get(index));
       String name = String.valueOf(jp.getList("name").get(index));
       String oldStatus = String.valueOf(jp.getList("status").get(index));

       jp = getRequest(id).jsonPath();
       String petid = jp.get("id").toString();
       String petname = jp.get("name");
       String petstatus = jp.get("status");

       // if petdata same return true else return false
        return id.equals(petid) && name.equals(petname) && oldStatus.equals(petstatus);

    }

    public int apiPostRequest() throws UnirestException {
       //request availeble pet
        jp = getRequest("findByStatus?status=available").jsonPath();
        // find second available pet's id
        String id = String.valueOf(jp.getList("id").get(1));
        String petNewName = faker.name().firstName();
        String petNewstatus = "pending";
        // post id, newname and new status
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(baseURI + id)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("name", petNewName)
                .field("status", petNewstatus)
                .asString();

        // get pet id and check the update
        jp = getRequest(id).jsonPath();
        String petname = jp.get("name");
        String petstatus = jp.get("status");
        if(petname.equals(petNewName) && petstatus.equals(petNewstatus)){
            return  response.getStatus();
        }else{
            return 404;
        }

    }
    public Response  apiDeleteRequest(String id){

        response = given()
                .header("content-type","application/json")
                .when()
                .delete(id)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();

        return response;


    }



}
