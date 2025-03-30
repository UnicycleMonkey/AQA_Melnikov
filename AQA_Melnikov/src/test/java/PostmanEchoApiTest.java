import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    public static Map<String,String> paramsGET = new HashMap<>();
    @BeforeAll
    static void prepare(){
        paramsGET.put("foo1", "bar1");
        paramsGET.put("foo2","bar2");
    }

    @Test
    void getRequestWoops(){
        given()
                .baseUri("https://postman-echo.com")
                .params(paramsGET)
                .when()
                .get("/get")
                .then().log().status().log().headers()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));

    }
}
