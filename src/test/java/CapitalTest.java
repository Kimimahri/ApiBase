import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;


public class CapitalTest {
    private String url = "http://restcountries.eu/rest/v1/name/russia";

    @Test
    private void getExample() {
        Response response = get(url);

        JSONArray jsonResponse = new JSONArray(response.asString());
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        Assert.assertEquals(capital, "Moscow");
    }
}
