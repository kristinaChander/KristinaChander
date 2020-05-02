package rest_assured.low_level.tests_with_no_spel_errors;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest_assured.low_level.GetPropertyUtil;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.URI.DOMAIN;

public class IgnoreDigitsTest {

    public static final String WORD_WITH_DIGITS = "7688799$";
    private RequestSpecification REQUEST_SPECIFICATION;


    @BeforeMethod
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(DOMAIN)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }



    @Test(description = "one word having digits")
    public void emptyBodyIfDigitsIgnored() {
        String options = GetPropertyUtil.getProperties().getProperty("optionIgnoreDigits");
        given(REQUEST_SPECIFICATION)
                .param("text", WORD_WITH_DIGITS)
                .param("options", options)
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));

    }

}
