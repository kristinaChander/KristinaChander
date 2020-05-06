package rest_assured.low_level.tests_with_no_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.TestData.ENGLISH_WORD_WITH_CAPS;
import static rest_assured.constants_and_utils.SpellerParameters.LANGUAGE;
import static rest_assured.constants_and_utils.SpellerParameters.OPTIONS;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.speller_service_description.Languages.ENGLISH;
import static rest_assured.speller_service_description.Options.IGNORE_CAPITALIZATION;

public class IgnoreCapitalizationTest extends LowLevelSetUp {
    @Test(description = "one word with caps")
    public void emptyBodyIfIgnoreCaps() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), ENGLISH_WORD_WITH_CAPS)
                .param(OPTIONS.getValue(), IGNORE_CAPITALIZATION.getValue())
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));
    }
}
