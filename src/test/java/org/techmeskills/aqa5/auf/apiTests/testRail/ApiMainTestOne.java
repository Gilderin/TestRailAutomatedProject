package org.techmeskills.aqa5.auf.apiTests.testRail;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiMainTestOne {
    @Test
    public void test() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
