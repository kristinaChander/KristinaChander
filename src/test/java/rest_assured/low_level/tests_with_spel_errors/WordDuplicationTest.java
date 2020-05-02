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
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.DOMAIN;

public class WordDuplicationTest {


    public static final String MANY_WORDS_DUPLICATION = "hello hello how how how are you";
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

    @Test(description = "Word duplication in a sentence")
    public void wordDuplicationInTextTest() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        String errorCode = GetPropertyUtil.getProperties().getProperty("errorCodeWordDuplication");
        String options = GetPropertyUtil.getProperties().getProperty("optionFindDuplication");
        given(REQUEST_SPECIFICATION)
                .param("text", MANY_WORDS_DUPLICATION)
                .param("lang", lang)
                .param("options",options)
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(Integer.valueOf(errorCode)))
                .body(notNullValue());
    }


}
