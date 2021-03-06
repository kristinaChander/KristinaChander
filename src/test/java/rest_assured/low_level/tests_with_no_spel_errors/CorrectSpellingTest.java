package rest_assured.low_level.tests_with_no_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.TestData.ONE_ENGLISH_WORD_CORRECT_SPELLING;
import static rest_assured.TestData.SENTENCE_ENGLISH_CORRECT_SPELLING;
import static rest_assured.constants_and_utils.SpellerParameters.LANGUAGE;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.speller_service_description.Languages.ENGLISH;

public class CorrectSpellingTest extends LowLevelSetUp {
    @Test(description = "one correctly spelled word")
    public void emptyBodyIfCorrectSpellingWord() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), ONE_ENGLISH_WORD_CORRECT_SPELLING)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));
    }

    @Test(description = "many correctly spelled words")
    void emptyBodyIfCorrectSpellingSentence() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), SENTENCE_ENGLISH_CORRECT_SPELLING)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXTS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[[]]"));
    }
}
