import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Date;


public class CustomerRegisterSchemaTest {
    private String url = "http://restapi.demoqa.com/customer/register";
    private File schemaFile = new File("./src/main/java/jsonSchemas/schema.json");
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
    public void schemaValidatorExample() {

        RequestSpecification request = RestAssured.given();
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(url)
                .then()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }
}
