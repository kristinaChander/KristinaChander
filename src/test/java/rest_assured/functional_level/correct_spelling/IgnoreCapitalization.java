package rest_assured.functional_level.correct_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.dto.SpellerDto;
import rest_assured.dto.SpellerParamDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import rest_assured.services.SpellerAssertions;

import static rest_assured.TestData.*;
import static rest_assured.speller_service_description.Languages.*;
import static rest_assured.speller_service_description.Options.IGNORE_CAPITALIZATION;

public class IgnoreCapitalization extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] capsCorrectCodeLang() {
        return new Object[][]{
                {ENGLISH_WORD_WITH_CAPS, ENGLISH.getValue()},
                {RUSSIAN_WORD_WITH_CAPS, RUSSIAN.getValue()},
                {UKRAINIAN_WORD_WITH_CAPS, UKRAINIAN.getValue()},
        };
    }

    @Test(description = "check word with caps", dataProvider = "capsCorrectCodeLang")
    void capsSpelledTest(String wrongWord, String lang) {

        SpellerDto[] textDescription = spellerService.getTextSpellerResult(new SpellerParamDto().builder()
                .text(wrongWord)
                .lang(lang)
                .options(IGNORE_CAPITALIZATION.getValue())
                .build());

        new SpellerAssertions(textDescription)
                .verifyEmptyBody();
    }
}
