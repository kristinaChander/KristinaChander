package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.TestData.SENTENCE_ENGLISH_DUPLICATION;
import static rest_assured.constants_and_utils.SpellerParameters.LANGUAGE;
import static rest_assured.constants_and_utils.SpellerParameters.OPTIONS;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.speller_service_description.ErrorCodes.WORD_DUPLICATION_ERROR;
import static rest_assured.speller_service_description.Languages.ENGLISH;
import static rest_assured.speller_service_description.Options.FIND_DUPLICATION;

public class WordDuplicationTest extends LowLevelSetUp {
    @Test(description = "Word duplication in a sentence")
    public void wordDuplicationInTextTest() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), SENTENCE_ENGLISH_DUPLICATION)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .param(OPTIONS.getValue(), FIND_DUPLICATION.getValue())
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(WORD_DUPLICATION_ERROR.getValue()))
                .body(notNullValue());
    }
}
