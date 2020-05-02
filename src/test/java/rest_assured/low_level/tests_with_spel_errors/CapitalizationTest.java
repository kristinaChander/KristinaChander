package rest_assured.low_level.tests_with_spel_errors;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest_assured.low_level.GetPropertyUtil;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.URI.DOMAIN;

public class CapitalizationTest {
    public static final String ONE_WORD_CAPS = "hELLO";
    private RequestSpecification REQUEST_SPECIFICATION;


    @BeforeMethod
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(DOMAIN)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @Test(description = "One word with caps")
    public void capsOneWordTest() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        String errorCode = GetPropertyUtil.getProperties().getProperty("errorCodeCaps");
        given(REQUEST_SPECIFICATION)
                .param("text", ONE_WORD_CAPS)
                .param("lang", lang)
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(Integer.valueOf(errorCode)))
                .body(notNullValue());
    }

}
