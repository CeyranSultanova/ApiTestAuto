import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_Get_ResponseBodyTestList {
    @Test public  void test(){
        //end point & reguestbody
        String url ="https://dummy.restapiexample.com/api/v1/employees";
        //reguestbody no
        //2 expected data
        //3request gonder responseni save et
        Response response=given().when().get(url);
       response.then().assertThat().
               statusCode(200).
               contentType(ContentType.JSON).body("data.id", Matchers.hasSize(24),
                       "data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(21,22,23));
    }
}
