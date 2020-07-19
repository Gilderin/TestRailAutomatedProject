package org.techmeskills.aqa5.auf.baseEntity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.techmeskills.aqa5.auf.core.ReadProperties;
import org.techmeskills.aqa5.auf.models.Users;
import org.techmeskills.aqa5.auf.utils.Listener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public ReadProperties properties;
    public Users master;
    public Users tester;

    @BeforeTest
    public void setup() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getApiUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
       //         .auth().preemptive().basic(properties.getApiUsername(), properties.getApiPassword());
        master = new Users.Builder().setEmail("atrostyanko+master@gmail.com").setIsActive(true).setName("AQA5 Master").build();
        tester = new Users.Builder().setEmail("atrostyanko+tester@gmail.com").setIsActive(true).setName("AQA5 Tester").build();
    }
}
