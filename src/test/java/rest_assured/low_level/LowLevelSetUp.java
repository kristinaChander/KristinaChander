package rest_assured.low_level;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static rest_assured.URI.DOMAIN;

public class LowLevelSetUp {

    protected RequestSpecification REQUEST_SPECIFICATION;

    @BeforeMethod
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(DOMAIN)
                .build();
    }
}
