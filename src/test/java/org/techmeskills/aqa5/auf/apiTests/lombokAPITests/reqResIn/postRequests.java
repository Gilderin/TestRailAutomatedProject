package org.techmeskills.aqa5.auf.apiTests.lombokAPITests.reqResIn;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.techmeskills.aqa5.auf.models.ProjectLombok;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postRequests extends BaseApiTest {

    @Test
    public void postCreate() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setName("andrey");
        projectLombok.setJob("A1");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", projectLombok.getName());
        jsonAsMap.put("job", projectLombok.getJob());

        String endpoint = "/api/users";
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .body("name", equalTo("Example1"))
                .body("job", equalTo("A1"));
    }

    @Test
    public void postRegisterSuccess() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setEmail("eve.holt@reqres.in");
        projectLombok.setPassword("123454");

        String endpoint = "/api/register";
        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\",\n" +
                        "    \"password\": \"%s\"\n" +
                        "}", projectLombok.getEmail(), projectLombok.getPassword()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postRegisterFail() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setEmail("sydney@fife");


        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", projectLombok.getEmail());

        String endpoint = "/api/register";
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void postLoginSuccess() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setEmail("eve.holt@reqres.in");
        projectLombok.setPassword("cityslicka");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", projectLombok.getEmail());
        jsonAsMap.put("password", projectLombok.getPassword());

        String endpoint = "/api/login";
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void postLoginFail() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setEmail("peter@klaven");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", projectLombok.getEmail());

        String endpoint = "/api/login";
        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", equalTo("Missing password"));
    }
}
