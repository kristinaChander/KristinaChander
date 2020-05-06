package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.dto.SpellerDto;
import rest_assured.dto.SpellerParamDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import rest_assured.services.SpellerAssertions;

import static rest_assured.TestData.*;
import static rest_assured.speller_service_description.ErrorCodes.CAPS_ERROR;
import static rest_assured.speller_service_description.Languages.*;

public class CapsWrongSpelling extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] capsCorrectCodeLang() {
        return new Object[][]{
                {ENGLISH_WORD_WITH_CAPS, ONE_ENGLISH_WORD_CORRECT_SPELLING, CAPS_ERROR.getValue(), ENGLISH.getValue()},
                {RUSSIAN_WORD_WITH_CAPS, ONE_RUSSIAN_WORD_CORRECT_SPELLING, CAPS_ERROR.getValue(), RUSSIAN.getValue()},
                {UKRAINIAN_WORD_WITH_CAPS, ONE_UKRAINIAN_WORD_CORRECT_SPELLING, CAPS_ERROR.getValue(), UKRAINIAN.getValue()},
        };
    }

    @Test(description = "check word with caps", dataProvider = "capsCorrectCodeLang")
    void capsSpelledTest(String wrongWord, String correctWord, Integer errorCode, String lang) {
        SpellerDto[] textDescription = spellerService.getTextSpellerResult(SpellerParamDto.builder()
                .text(wrongWord)
                .lang(lang)
                .build());

        new SpellerAssertions(textDescription)
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode)
                .verifyBodyHasCorrectedWord(correctWord)
                .verifyBodyHasIncorrectWord(wrongWord);
    }
}
