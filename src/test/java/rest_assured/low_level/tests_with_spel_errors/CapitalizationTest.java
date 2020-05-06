package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.TestData.ENGLISH_WORD_WITH_CAPS;
import static rest_assured.constants_and_utils.SpellerParameters.LANGUAGE;
import static rest_assured.constants_and_utils.SpellerParameters.TEXT;
import static rest_assured.constants_and_utils.URI.CHECK_TEXT_ENDPOINT;
import static rest_assured.speller_service_description.ErrorCodes.CAPS_ERROR;
import static rest_assured.speller_service_description.Languages.ENGLISH;

public class CapitalizationTest extends LowLevelSetUp {
    @Test(description = "One word with caps")
    public void capsOneWordTest() {
        given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), ENGLISH_WORD_WITH_CAPS)
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(CAPS_ERROR.getValue()))
                .body(notNullValue());
    }
}
