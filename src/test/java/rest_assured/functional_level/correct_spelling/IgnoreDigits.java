package rest_assured.functional_level.correct_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;

import static rest_assured.Constants.*;

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
    void CapsSpelledTest(String digitWord) {
        SpellerDto[] textDescription = spellerService.getSpellingOneWordCheckResult(digitWord, OPTION_IGNORE_DIGITS);

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription);
        spellerAssertions
                .verifyEmptyBody();
    }
}
