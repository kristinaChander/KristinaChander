package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static rest_assured.Constants.*;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class WrongSpellingTest extends LowLevelSetUp {
    @Test(description = "One word with wrong spelling")
    public void wrongSpellingOneWordTest() {
        String lang = ENGLISH_LANG;
        Integer errorCode = ERROR_CODE_NOT_IN_THE_DICTIONARY;
        given(REQUEST_SPECIFICATION)
                .param("text", ONE_ENGLISH_WORD_WRONG_SPELLING)
                .param("lang", lang)
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(Integer.valueOf(errorCode)))
                .body("[0].s", hasItem(ONE_ENGLISH_WORD_CORRECT_SPELLING));
    }

    @Test(description = "Many words with wrong spelling")
    public void wrongSpellingSentenceTest() {
        String lang = ENGLISH_LANG;
        Integer errorCode = ERROR_CODE_NOT_IN_THE_DICTIONARY;
        given(REQUEST_SPECIFICATION)
                .param("text", SENTENCE_ENGLISH_WRONG_SPELLING)
                .param("lang", lang)
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(errorCode))
                .body(notNullValue());
    }
}