package rest_assured.low_level.tests_with_no_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.Constants.ENGLISH_LANG;
import static rest_assured.Constants.OPTION_IGNORE_CAPITALIZATION;
import static rest_assured.Constants.ENGLISH_WORD_WITH_CAPS;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class IgnoreCapitalizationTest extends LowLevelSetUp {
    @Test(description = "one word with caps")
    public void emptyBodyIfIgnoreCaps() {
        Integer options = OPTION_IGNORE_CAPITALIZATION;
        String lang = ENGLISH_LANG;
        given(REQUEST_SPECIFICATION)
                .param("text", ENGLISH_WORD_WITH_CAPS)
                .param("options", options)
                .param("lang", lang)
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));

    }
}
