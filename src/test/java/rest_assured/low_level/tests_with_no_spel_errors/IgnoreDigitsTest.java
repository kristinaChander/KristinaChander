package rest_assured.low_level.tests_with_no_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static rest_assured.Constants.OPTION_IGNORE_DIGITS;
import static rest_assured.Constants.WORD_WITH_DIGITS;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class IgnoreDigitsTest extends LowLevelSetUp {
    @Test(description = "one word having digits")
    public void emptyBodyIfDigitsIgnored() {
        Integer options = OPTION_IGNORE_DIGITS;
        given(REQUEST_SPECIFICATION)
                .param("text", WORD_WITH_DIGITS)
                .param("options", options)
                .get(CHECK_TEXT_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK).and()
                .body(is("[]"));
    }
}
