package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.dto.SpellerDto;
import rest_assured.dto.SpellerParamDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import rest_assured.services.SpellerAssertions;

import static rest_assured.TestData.*;
import static rest_assured.speller_service_description.ErrorCodes.NOT_IN_THE_DICTIONARY_ERROR;
import static rest_assured.speller_service_description.Languages.*;

public class IncorrectSpellingTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] correctAndErrorWordsAndCodes() {
        return new Object[][]{
                {ONE_ENGLISH_WORD_WRONG_SPELLING, ONE_ENGLISH_WORD_CORRECT_SPELLING, NOT_IN_THE_DICTIONARY_ERROR.getValue(), ENGLISH.getValue()},
                {ONE_RUSSIAN_WORD_WRONG_SPELLING, ONE_RUSSIAN_WORD_CORRECT_SPELLING, NOT_IN_THE_DICTIONARY_ERROR.getValue(), RUSSIAN.getValue()},
                {ONE_UKRAINIAN_WORD_WRONG_SPELLING, ONE_UKRAINIAN_WORD_CORRECT_SPELLING, NOT_IN_THE_DICTIONARY_ERROR.getValue(), UKRAINIAN.getValue()},
        };
    }

    @Test(description = "check incorrectly spelled word", dataProvider = "correctAndErrorWordsAndCodes")
    void oneIncorrectWordTest(String wrongWord, String correctWord, Integer errorCode, String lang) {
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

    @DataProvider
    public Object[][] errorSentenceAndLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_WRONG_SPELLING, ENGLISH.getValue()},
                {SENTENCE_RUSSIAN_WRONG_SPELLING, RUSSIAN.getValue()},
                {SENTENCE_UKRAINIAN_WRONG_SPELLING, UKRAINIAN.getValue()},
        };
    }

    @Test(description = "check incorrectly spelled sentence", dataProvider = "errorSentenceAndLang")
    void incorrectSentenceTest(String sentence, String lang) {
        SpellerDto[][] textDescription = spellerService.getTextsSpellerResult(SpellerParamDto.builder()
                .text(sentence)
                .lang(lang)
                .build());

        new SpellerAssertions(textDescription[0])
                .verifyNotEmptyBody();
    }
}
