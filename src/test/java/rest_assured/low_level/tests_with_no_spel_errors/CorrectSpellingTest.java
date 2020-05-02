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
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.URI.DOMAIN;

public class CorrectSpellingTest {

    public static final String SENTENCE_CORRECT_SPELLING = "Cat is nice";
    public static final String WORD_CORRECT_SPELLING = "Cat";
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


    @Test(description = "one correctly spelled word")
    public void emptyBodyIfCorrectSpellingWord() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        given(REQUEST_SPECIFICATION)
                .param("text", WORD_CORRECT_SPELLING)
                .param("lang",lang )
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));

    }

    @Test(description = "many correctly spelled words")
    void emptyBodyIfCorrectSpellingSentence() {
        String lang = GetPropertyUtil.getProperties().getProperty("englishLang");
        given(REQUEST_SPECIFICATION)
                .param("text", SENTENCE_CORRECT_SPELLING)
                .param("lang",lang )
                .get(CHECK_TEXTS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[[]]"));

    }


}
