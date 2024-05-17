import io.restassured.http.ContentType;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import io.restassured.response.Response;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C15_post_ExpectedData {
    @Test public  void  test(){
        //end point request body
        String url="https://restful-booker.herokuapp.com/booking ";
        JSONObject requestBody=new JSONObject();
        JSONObject rezervasionDateJson=new JSONObject();
        rezervasionDateJson.put("checkin","2023-01-10");
        rezervasionDateJson.put("checkout","2023-01-20");
        requestBody.put("firstname","Test");
        requestBody.put("lastname","test");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasionDateJson);
        requestBody.put("additionalneeds","wi-fi");
        //expected data
        JSONObject expectedData =new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);

        //request gonder response save
        Response response= given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        // assertion
        JsonPath responseJsonPath=response.jsonPath();
        //expected==>jsonobject
        //actual==>response responsepath
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));

    }
}
