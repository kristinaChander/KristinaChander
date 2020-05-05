package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static rest_assured.SpellerServiceDescription.ENGLISH_LANG;
import static rest_assured.SpellerServiceDescription.ERROR_CODE_NOT_IN_THE_DICTIONARY;
import static rest_assured.TestData.*;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class WrongSpellingTest extends LowLevelSetUp {
    @Test(description = "One word with wrong spelling")
    public void wrongSpellingOneWordTest() {
        given(REQUEST_SPECIFICATION)
                .param("text", ONE_ENGLISH_WORD_WRONG_SPELLING)
                .param("lang", ENGLISH_LANG)
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(ERROR_CODE_NOT_IN_THE_DICTIONARY))
                .body("[0].s", hasItem(ONE_ENGLISH_WORD_CORRECT_SPELLING));
    }

    @Test(description = "Many words with wrong spelling")
    public void wrongSpellingSentenceTest() {
        given(REQUEST_SPECIFICATION)
                .param("text", SENTENCE_ENGLISH_WRONG_SPELLING)
                .param("lang", ENGLISH_LANG)
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(ERROR_CODE_NOT_IN_THE_DICTIONARY))
                .body(notNullValue());
    }
}