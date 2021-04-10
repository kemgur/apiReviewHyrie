package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import utilities.TestBase;

import static io.restassured.RestAssured.given;

public class api0707 extends TestBase {
     /*
		 When
			 I send a GET request to REST API URL
			 // Bu kisma base url denir.
			 https://jsonplaceholder.typicode.com/todos/123
	     Then
		     HTTP Status Code should be 200
		     And "Server" in Headers should be "cloudflare"
		     And response content type is “application/JSON”
		     And "userId" should be 7,
		     And "title" should be "esse et quis iste est earum aut impedit"
			 And "completed" should be false
	*/
    @Test
    public void test(){
              //pathParam() key and value formatinda calisir
        spec01.pathParam("id",123);
                                                            //{} icerisinde yazmak zorundayiz/
        Response response = given().spec(spec01).when().get("/{id}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", equalTo(7),
                        "title",equalTo("esse et quis iste est earum aut impedit"),
                        "completed",equalTo(false));
                        //JUnit'lerde once expected data girilir sonra actual data gelir.
        Assert.assertEquals("cloudflare",response.getHeader("server"));

    }
}
