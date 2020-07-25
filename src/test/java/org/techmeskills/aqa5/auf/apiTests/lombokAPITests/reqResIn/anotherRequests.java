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

public class anotherRequests extends BaseApiTest {

    @Test
    public void putUpdate() {
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setName("andrey");
        projectLombok.setJob("A1");


        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", projectLombok.getName());
        jsonAsMap.put("job", projectLombok.getJob());

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
        ProjectLombok projectLombok = ProjectLombok.builder().build();
        projectLombok.setName("andrey");
        projectLombok.setJob("A1");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", projectLombok.getName());
        jsonAsMap.put("job", projectLombok.getJob());

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
