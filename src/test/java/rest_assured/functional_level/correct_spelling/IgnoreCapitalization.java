package rest_assured.functional_level.correct_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;

import static rest_assured.Constants.*;

public class IgnoreCapitalization extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] capsCorrectCodeLang() {
        return new Object[][]{
                {ENGLISH_WORD_WITH_CAPS, ENGLISH_LANG},
                {RUSSIAN_WORD_WITH_CAPS, RUSSIAN_LANG},
                {UKRANIAN_WORD_WITH_CAPS, UKRANIAN_LANG},
        };
    }

    @Test(description = "check word with caps", dataProvider = "capsCorrectCodeLang")
    void CapsSpelledTest(String wrongWord, String lang) {
        SpellerDto[] textDescription = spellerService.getSpellingOneWordCheckResult(wrongWord, lang, OPTION_IGNORE_CAPITALIZATION);

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription);
        spellerAssertions
                .verifyEmptyBody();
    }
}
