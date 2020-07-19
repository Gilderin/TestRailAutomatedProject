package org.techmeskills.aqa5.auf.apiTests.reqResIn;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Users;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class getRequests extends BaseApiTest {

    @Test
    public void getListUsers() {
        String endpoint = "/api/users?page=2";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("page", is(2));
    }

    @Test
    public void getSingleUsers() {
        String endpoint = "/api/users/2";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",is(2));
    }

    @Test
    public void getSingleUserNotFound() {
        String endpoint = "/api/users/23";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void getListResource() {
        String endpoint = "/api/unknown";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("page",is(1))
                .body("data.get(0).id",is(1))
                .body("data.get(0).name",equalTo("cerulean"));
    }

    @Test
    public void getSingleResource() {
        String endpoint = "/api/unknown/2";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",is(2))
                .body("data.name",equalTo("fuchsia rose"));
    }

    @Test
    public void getSingleResourceNotFound() {
        String endpoint = "/api/unknown/23";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void getDelayResponse() {
        String endpoint = "api/users?delay=3";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("page",is(1))
                .body("ad.company",equalTo("StatusCode Weekly"));
    }
}
