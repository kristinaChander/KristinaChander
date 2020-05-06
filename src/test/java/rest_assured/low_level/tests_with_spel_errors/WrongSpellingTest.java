package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static rest_assured.TestData.*;
import static rest_assured.constants_and_utils.SpellerParameters.LANGUAGE;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.speller_service_description.ErrorCodes.NOT_IN_THE_DICTIONARY_ERROR;
import static rest_assured.speller_service_description.Languages.ENGLISH;

public class WrongSpellingTest extends LowLevelSetUp {
    @Test(description = "One word with wrong spelling")
    public void wrongSpellingOneWordTest() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), ONE_ENGLISH_WORD_WRONG_SPELLING)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(NOT_IN_THE_DICTIONARY_ERROR.getValue()))
                .body("[0].s", hasItem(ONE_ENGLISH_WORD_CORRECT_SPELLING));
    }

    @Test(description = "Many words with wrong spelling")
    public void wrongSpellingSentenceTest() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), SENTENCE_ENGLISH_WRONG_SPELLING)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(NOT_IN_THE_DICTIONARY_ERROR.getValue()))
                .body(notNullValue());
    }
}