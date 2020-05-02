package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.Constants.*;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;

public class WordDuplicationTest extends LowLevelSetUp {

    @Test(description = "Word duplication in a sentence")
    public void wordDuplicationInTextTest() {
        String lang = ENGLISH_LANG;
        Integer errorCode = ERROR_CODE_WORD_DUPLICATION;
        Integer options = OPTION_FIND_DUPLICATION;
        given(REQUEST_SPECIFICATION)
                .param("text", SENTENCE_ENGLISH_DUPLICATION)
                .param("lang", lang)
                .param("options", options)
                .get(CHECK_TEXTS_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", hasItem(errorCode))
                .body(notNullValue());
    }
}
