package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class api01 {
    @Test
    public void test(){
    //given() => static olarak import ediyoruz ve RestAssured'den aliyoruz
       //Genel olarak data isteme mantigi
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        //ContentType.JSON => yerine string olarak "application/JSON" seklinde de yazilabilir.
        System.out.println(response.statusCode());
        //Status code'un 200 olmasi demek(Sen benden bir sey istedin ve ben onu sana verdim)
        //Status code'un 404 olmasi demek(Sen benden bir sey istedin ama o bende yok)
        //Status code'un 500 olmasi demek(Sen benden bir sey istedin ama sistemde bir hata var.)

    }
    }



