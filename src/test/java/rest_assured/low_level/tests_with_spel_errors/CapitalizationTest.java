package rest_assured.low_level.tests_with_spel_errors;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import rest_assured.low_level.LowLevelSetUp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static rest_assured.Constants.*;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class CapitalizationTest extends LowLevelSetUp {
    @Test(description = "One word with caps")
    public void capsOneWordTest() {
        String lang = ENGLISH_LANG;
        Integer errorCode = ERROR_CODE_CAPS;
        given(REQUEST_SPECIFICATION)
                .param("text", ENGLISH_WORD_WITH_CAPS)
                .param("lang", lang)
                .get(CHECK_TEXT_ENDPOINT)
                .then().statusCode(HttpStatus.SC_OK).and()
                .body("[0].code", is(errorCode))
                .body(notNullValue());
    }
}
