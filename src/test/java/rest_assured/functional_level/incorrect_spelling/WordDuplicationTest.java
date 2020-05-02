package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;

import static rest_assured.Constants.*;

public class WordDuplicationTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] duplSentenceCodeLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, ENGLISH_LANG},
                {SENTENCE_RUSSIAN_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, RUSSIAN_LANG},
                {SENTENCE_UKRANIAN_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, UKRANIAN_LANG},
        };
    }

    @Test(description = "check sentence with word duplications", dataProvider = "duplSentenceCodeLang")
    void CapsSpelledTest(String duplSentence, Integer errorCode, String lang) {
        SpellerDto[][] textDescription = spellerService.getSpellingSentenceCheckResult(duplSentence, lang, OPTION_FIND_DUPLICATION);

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription[0]);
        spellerAssertions
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode);
    }
}
