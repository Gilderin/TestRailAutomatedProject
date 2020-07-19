package org.techmeskills.aqa5.auf.apiTests.reqResIn;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.techmeskills.aqa5.auf.models.ProjectTypes;
import org.techmeskills.aqa5.auf.models.Users;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class anotherRequests extends BaseApiTest {

    @Test
    public void putUpdate() {
        Project project = new Project.Builder()
                .withName("andrey")
                .withJob("A1")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        String endpoint = "/api/users/2";
        given()
                .body(jsonAsMap)
                .when()
                .put(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name",equalTo("andrey"))
                .body("job",equalTo("A1"));
    }

    @Test
    public void patchUpdate() {
        Project project = new Project.Builder()
                .withName("andrey")
                .withJob("A1")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        String endpoint = "/api/users/2";
        given()
                .body(jsonAsMap)
                .when()
                .patch(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
        .body("name",equalTo("andrey"))
        .body("job",equalTo("A1"));
    }

    @Test
    public void delete() {
        String endpoint = "/api/users/2";
        given()
                .when()
                .delete(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }
}
