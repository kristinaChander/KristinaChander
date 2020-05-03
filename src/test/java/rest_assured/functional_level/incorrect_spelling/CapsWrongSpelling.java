package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;

import static rest_assured.Constants.*;

public class CapsWrongSpelling extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] capsCorrectCodeLang() {
        return new Object[][]{
                {ENGLISH_WORD_WITH_CAPS, ONE_ENGLISH_WORD_CORRECT_SPELLING, ERROR_CODE_CAPS, ENGLISH_LANG},
                {RUSSIAN_WORD_WITH_CAPS, ONE_RUSSIAN_WORD_CORRECT_SPELLING, ERROR_CODE_CAPS, RUSSIAN_LANG},
                {UKRAINIAN_WORD_WITH_CAPS, ONE_UKRAINIAN_WORD_CORRECT_SPELLING, ERROR_CODE_CAPS, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check word with caps", dataProvider = "capsCorrectCodeLang")
    void CapsSpelledTest(String wrongWord, String correctWord, Integer errorCode, String lang) {
        SpellerDto[] textDescription = spellerService.getSpellingOneWordCheckResult(wrongWord, lang);

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription);
        spellerAssertions
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode)
                .verifyBodyHasCorrectedWord(correctWord)
                .verifyBodyHasIncorrectWord(wrongWord);
    }
}
