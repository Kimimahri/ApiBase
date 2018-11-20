import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Date;


public class CustomerRegisterTest {

    private String url = "http://restapi.demoqa.com/customer/register";
    private JSONObject requestBody = new JSONObject();

    @BeforeTest
    public void setUp() {
        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());

        requestBody.put("FirstName", someRandomString);
        requestBody.put("LastName", someRandomString);
        requestBody.put("UserName", someRandomString);
        requestBody.put("Password", someRandomString);
        requestBody.put("Email", someRandomString + "@gmail.com");
    }

    @Test
    public void postExample() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post(url);

        int statusCode = response.getStatusCode();
        String successCode = response.jsonPath().get("SuccessCode");

        Assert.assertEquals(statusCode, 201);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
    }
}
