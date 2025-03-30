import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    private final static String BASE_URI = "https://postman-echo.com";
    private static ResponseSpecification response200Spec;

    @BeforeAll
    static void prep(){
        RestAssured.baseURI=BASE_URI;
        response200Spec = expect().statusCode(HttpStatus.SC_OK); //потому что могу
    }


    @Test
    @DisplayName("Метод GET")
    void getRequest(){
        Map<String,String> params = new HashMap<>();
        params.put("foo1", "bar1");
        params.put("foo2","bar2");

        given()
                .params(params)
                .when()
                .get("/get")
                .then()
                .log().status()
                .log().headers()
//                .assertThat().statusCode(HttpStatus.SC_OK)
                .spec(response200Spec)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
        ;
    }

    @Test
    @DisplayName("Метод POST (текст)")
    void postRequestText(){
        String content="bla-bla-bla";
        given()
                .body(content)
                .when().log().body()
                .post("/post")
                .then()
                .log().status()
                .log().body()
                .spec(response200Spec)
                .body("data", equalTo(content))
        ;
    }

    @Test
    @DisplayName("Метод POST (значения)")
    void postRequestData(){
        String [] keys = new String[] {"foo1","foo2"};
        String [] values = new String[] {"bar1","bar2"};
        JSONObject requestParams = initializeJSONObject(keys, values);

        given()
                .body(requestParams.toString()).contentType("application/json")
                .when().log().body()
                .post("/post")
                .then()
                .log().status()
                .log().body()
                .spec(response200Spec)
                .and().body("data."+keys[0],equalTo(values[0]))
                .and().body("data."+keys[1],equalTo(values[1]))
        ;
    }

    @Test
    @DisplayName("Метод PUT")
    void putRequestText(){
        String content="bla-bla...bla?";
        given()
                .body(content)
                .contentType("application/json")
                .when().log().body()
                .put("/put")
                .then()
                .log().status()
                .log().body()
                .spec(response200Spec)
                .body("data", equalTo(content))
        ;
    }

    @Test
    @DisplayName("Метод PATCH")
    void patchRequestText(){
        String content="Om-nom-nom!";
        given()
                .body(content)
                .contentType("application/json")
                .when().log().body()
                .patch("/patch")
                .then()
                .log().status()
                .log().body()
                .spec(response200Spec)
                .body("data", equalTo(content))
        ;
    }

    @Test
    @DisplayName("Метод DELETE")
    void deleteRequestText(){
        String content="Om-nom-nom!";
        given()
                .body(content)
                .contentType("application/json")
                .when().log().body()
                .delete("/delete")
                .then()
                .spec(response200Spec)
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo(content))
        ;
    }

    private JSONObject initializeJSONObject(String[] keys, String[] values) {
        JSONObject result = new JSONObject();
        for (int i = 0; i < keys.length; i++) {
            String val = (i< values.length)? values[i] : "";
            result.put(keys[i],val);
        }
        return result;
    }

}
