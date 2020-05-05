package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.Services.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import static rest_assured.Constants.*;

public class IncorrectSpellingTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] correctAndErrorWordsAndCodes() {
        return new Object[][]{
                {ONE_ENGLISH_WORD_WRONG_SPELLING, ONE_ENGLISH_WORD_CORRECT_SPELLING, ERROR_CODE_NOT_IN_THE_DICTIONARY, ENGLISH_LANG},
                {ONE_RUSSIAN_WORD_WRONG_SPELLING, ONE_RUSSIAN_WORD_CORRECT_SPELLING, ERROR_CODE_NOT_IN_THE_DICTIONARY, RUSSIAN_LANG},
                {ONE_UKRAINIAN_WORD_WRONG_SPELLING, ONE_UKRAINIAN_WORD_CORRECT_SPELLING, ERROR_CODE_NOT_IN_THE_DICTIONARY, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check incorrectly spelled word", dataProvider = "correctAndErrorWordsAndCodes")
    void oneIncorrectWordTest(String wrongWord, String correctWord, Integer errorCode, String lang) {
        SpellerDto[] textDescription = spellerService.checkOneWordWithLang(wrongWord, lang);

        new SpellerAssertions(textDescription)
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode)
                .verifyBodyHasCorrectedWord(correctWord)
                .verifyBodyHasIncorrectWord(wrongWord);
    }

    @DataProvider
    public Object[][] errorSentenceAndLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_WRONG_SPELLING, ENGLISH_LANG},
                {SENTENCE_RUSSIAN_WRONG_SPELLING, RUSSIAN_LANG},
                {SENTENCE_UKRAINIAN_WRONG_SPELLING, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check incorrectly spelled sentence", dataProvider = "errorSentenceAndLang")
    void incorrectSentenceTest(String sentence, String lang) {
        SpellerDto[][] textDescription = spellerService.checkSentenceWithLang(sentence, lang);

       new SpellerAssertions(textDescription[0])
               .verifyNotEmptyBody();
    }
}
