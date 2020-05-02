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
import static org.hamcrest.Matchers.*;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.URI.DOMAIN;

public class WrongSpellingTest {

    public static final String ONE_WORD_WRONG_SPELLING = "Helo";
    public static final String MANY_WORDS_WRONG_SPELLING = "heloo haw ar yo";
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

    @Test(description = "One word with wrong spelling")
    public void wrongSpellingOneWordTest() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        String errorCode = GetPropertyUtil.getProperties().getProperty("errorCodeNotInTheDictionary");
        given(REQUEST_SPECIFICATION)
                .param("text", ONE_WORD_WRONG_SPELLING)
                .param("lang", lang)
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(Integer.valueOf(errorCode)))
                .body("[0].s", hasItem("Hello"));
    }

    @Test(description = "Many words with wrong spelling")
    public void wrongSpellingSentenceTest() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        String errorCode = GetPropertyUtil.getProperties().getProperty("errorCodeNotInTheDictionary");
        given(REQUEST_SPECIFICATION)
                .param("text", MANY_WORDS_WRONG_SPELLING)
                .param("lang", lang)
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(Integer.valueOf(errorCode)))
                .body(notNullValue());
    }
}
