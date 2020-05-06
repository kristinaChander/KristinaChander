package rest_assured.low_level.tests_with_no_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.TestData.WORD_WITH_DIGITS;
import static rest_assured.constants_and_utils.SpellerParameters.OPTIONS;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.speller_service_description.Options.IGNORE_DIGITS;

public class IgnoreDigitsTest extends LowLevelSetUp {
    @Test(description = "one word having digits")
    public void emptyBodyIfDigitsIgnored() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), WORD_WITH_DIGITS)
                .param(OPTIONS.getValue(), IGNORE_DIGITS.getValue())
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));
    }
}
