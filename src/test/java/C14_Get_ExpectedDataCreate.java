import com.beust.ah.A;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C14_Get_ExpectedDataCreate {
    @Test public void test(){
        //end point
        String url ="https://jsonplaceholder.typicode.com/posts/1";
        //2expected data
        JSONObject expecedData=new JSONObject();
        expecedData.put("userId",1);
        expecedData.put("id",1);
        expecedData.put("title","sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        expecedData.put("body","quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        //request gonder response save
        Response response=given().when().get(url);
        JsonPath responseJsonPath =response.jsonPath();
        Assert.assertEquals(expecedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expecedData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expecedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expecedData.get("body"),responseJsonPath.get("body"));

    }
}
