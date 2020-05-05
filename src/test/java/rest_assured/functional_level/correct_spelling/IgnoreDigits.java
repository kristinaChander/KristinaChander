package rest_assured.functional_level.correct_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.Services.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.SpellerParamDto;
import rest_assured.functional_level.SetUpFunctionalLevel;

import static rest_assured.SpellerServiceDescription.OPTION_IGNORE_DIGITS;
import static rest_assured.TestData.*;

public class IgnoreDigits extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] digits() {
        return new Object[][]{
                {WORD_WITH_DIGITS},
                {WORD_WITH_DIGITS2},
                {WORD_WITH_DIGITS3},
        };
    }

    @Test(description = "check word with digits", dataProvider = "digits")
    void capsSpelledTest(String digitWord) {
        SpellerDto[] textDescription = spellerService.getTextSpellerResult(SpellerParamDto.builder()
                .text(digitWord)
                .options(OPTION_IGNORE_DIGITS)
                .build());

         new SpellerAssertions(textDescription)
                .verifyEmptyBody();
    }
}
