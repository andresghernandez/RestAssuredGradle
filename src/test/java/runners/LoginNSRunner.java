package runners;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginNSRunner {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api";
        RestAssured.filters(new ResponseLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void LoginTest(){
        String body = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
       Response response =  given()
                .body(body)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response();

       int statusCode = response.statusCode();

       assertThat(statusCode, equalTo(200));

    }


}
