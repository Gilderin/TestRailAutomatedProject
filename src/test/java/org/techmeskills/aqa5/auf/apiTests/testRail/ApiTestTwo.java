package org.techmeskills.aqa5.auf.apiTests.testRail;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTestTwo {
    String baseUrl = "https://aqa5master.testrail.io/";
    String endpoint = "index.php?/api/v2/get_users";

    @Test
    public void testOne() {
        RestAssured.baseURI = baseUrl;

        RequestSpecification htttpRequest = given();
        htttpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        htttpRequest.auth().preemptive().basic("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        Response response = htttpRequest.request(Method.GET, endpoint);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        String resp = response.getBody().asString();

        System.out.println("Body:" + resp);

        Assert.assertEquals(statusCode, 200, "Invalid Status code");
    }

    @Test
    public void testTwo() {
        RestAssured.baseURI = baseUrl;

        given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ")
            .when()
                .get("index.php?/api/v2/get_users")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();

    }
}
