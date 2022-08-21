
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Api {
    Response response;

   public Api(){

       baseURI = "https://petstore.swagger.io/v2/pet/";
   }

    public int getRequest(String requestUrl){
        response = given()
                .header("content-type","application/json")
                .when()
                .get(requestUrl)
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();
        return response.statusCode();
    }

    public void apiGetidStatusCheck(int id){

        response = given()
                .header("content-type","application/json")
                .when()
                .get(String.valueOf(id))
                .then()
                .statusCode(200)
                .and()
                .extract()
                .response();

        JsonPath jp = response.jsonPath();
        String i = String.valueOf(jp.getList("id").get(2));

    }


}
