package org.techmeskills.aqa5.auf.apiTests.reqResIn;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.techmeskills.aqa5.auf.models.ProjectTypes;
import org.techmeskills.aqa5.auf.models.Users;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class postRequests extends BaseApiTest {
    @Test
    public void postCreate() {
        Project project = new Project.Builder()
                .withName("Example1")
                .withJob("A1")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

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
        Project project = new Project.Builder()
                .withEmail("eve.holt@reqres.in")
                .withPassword("123454")
                .build();

        String endpoint = "/api/register";
        given()
                .body(String.format("{\n" +
                        "    \"email\": \"%s\",\n" +
                        "    \"password\": \"%s\"\n" +
                        "}", project.getEmail(), project.getPassword()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
        //.body(hasItemInArray("id"))
    }

    @Test
    public void postRegisterFail() {
        Project project = new Project.Builder()
                .withEmail("sydney@fife")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());

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
        Project project = new Project.Builder()
                .withEmail("eve.holt@reqres.in")
                .withPassword("cityslicka")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

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
        Project project = new Project.Builder()
                .withEmail("peter@klaven")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());

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
