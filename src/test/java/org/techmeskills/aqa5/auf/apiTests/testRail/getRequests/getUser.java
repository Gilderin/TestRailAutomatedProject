package org.techmeskills.aqa5.auf.apiTests.testRail.getRequests;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Users;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getUser extends BaseApiTest {
    @Test
    public void testTwo() {
        Users users=tester;
        String endpoint="index.php?/api/v2/get_user/2";
        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
        .body("name",is(users.getName()))
        .body("email",equalTo(users.getEmail()))
        .body("is_active",is(users.isActive()));
    }
    @Test
    public void project() {
        Users users=tester;
        String endpoint="index.php?/api/v2/get_projects";
        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();


    }


}
