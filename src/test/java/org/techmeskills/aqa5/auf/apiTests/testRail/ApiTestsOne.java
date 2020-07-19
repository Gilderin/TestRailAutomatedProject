package org.techmeskills.aqa5.auf.apiTests.testRail;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTestsOne {
    String baseUrl="https://reqres.in";
    String endpoint="/api/users/2";
    @Test
    public void testOne(){
        RestAssured.baseURI=baseUrl;

        RequestSpecification htttpRequest=RestAssured.given();

        Response response=htttpRequest.request(Method.GET,endpoint);

        int statusCode=response.getStatusCode();
        System.out.println("Status Code: "+statusCode);
        String resp=response.getBody().asString();

        System.out.println("Body:"+resp);

        Assert.assertEquals(statusCode,200,"Invalid Status code");
    }
}
