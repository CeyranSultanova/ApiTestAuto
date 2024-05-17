import org.json.JSONObject;
import org.junit.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C12_Post_JsonPathle_BodyTest {
    @Test public  void  testo1(){
       //1ci addim end point ve request body yaradilmasi
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody=new JSONObject();
        JSONObject rezervasionDate= new JSONObject();
        rezervasionDate.put("checkin","2023-01-10");
        rezervasionDate.put("checkout","2023-01-20");
        requestBody.put("firstname","Test");
        requestBody.put("lastname","test");
        requestBody.put("totalprice","500");
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasionDate);
        requestBody.put("additionalneeds","wi-fi");
        //2ci addim expected data yaradilir
        //3 addim request gonder ve donen responseni yadda saxla

        Response response= given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        response.prettyPrint();
        //assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("booking.firstname", equalTo("Test"),
                        "booking.lastname",equalTo("test"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));

    }
}
