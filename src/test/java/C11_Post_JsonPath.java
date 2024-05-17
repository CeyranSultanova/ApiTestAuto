import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class C11_Post_JsonPath {
    @Test
    public void test01(){
        //endpoint and request create
        String  url="https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody=new JSONObject();
        JSONObject Bookingdates =new JSONObject();
        Bookingdates.put("checkin","2023-01-10");
        Bookingdates.put("checkout","2023-01-20");
        requestBody.put("firstname","Ceyran");
        requestBody.put("lastname","sultanova");
        requestBody.put("totalprice",100);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",Bookingdates);
        requestBody.put("additionalneeds","wi-fi");
        //expected datacreating
        // send request ,get response
        Response response =given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        response.prettyPrint();
        //eger body gonderilirse givenden sonra content type verilmelidi
        //whende hansi bodyi gonderdiyimizi elave etmeliyik
        //responseni gormek istesek

    }


}
