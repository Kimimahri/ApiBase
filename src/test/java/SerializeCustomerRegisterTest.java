import deserialization.CustomerRegisterInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import serialization.CustomerInfo;

import java.util.Date;


public class SerializeCustomerRegisterTest {

    private String url = "http://restapi.demoqa.com/customer/register";
    private JSONObject requestBody = new JSONObject();
    private CustomerInfo customerInfo;

    @BeforeTest
    public void setUp() {
        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());

        customerInfo = new CustomerInfo(someRandomString, someRandomString, someRandomString, someRandomString, someRandomString);
    }

    @Test
    public void postExample() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(customerInfo);
        CustomerRegisterInfo customerRegisterInfo = request
                .post(url)
                .then()
                .statusCode(201)
                .extract()
                .as(CustomerRegisterInfo.class);

        Assert.assertEquals(customerRegisterInfo.SuccessCode, "OPERATION_SUCCESS");
    }
}
