package goRest;

import goRest.model.Users;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestUsersTests {

    @Test
    public void getUsers()
    {
        List<Users> userList=
        given()
                .when()
                .get("https://gorest.co.in/public-api/users") // request linkini çalıştırdık.
                .then()
                .log().body()
                .statusCode(200) // dönenen durumun kontrolünü yaptık
                .contentType(ContentType.JSON) // burda dönen verinin type ni kontrol ettik.
                .body("code", equalTo(200)) // dönen (respons) body nin ilk bölümündeki code un değeri kontorl edildi.
                .body("data", not(empty())) // data bölümünün bboş olmadığı kontrol edildi.
                .extract().jsonPath().getList("data" , Users.class)
       ;


    }



}
