package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.Services.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import static rest_assured.Constants.*;

public class WordDuplicationTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] duplSentenceCodeLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, ENGLISH_LANG},
                {SENTENCE_RUSSIAN_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, RUSSIAN_LANG},
                {SENTENCE_UKRAINIAN_DUPLICATION, ERROR_CODE_WORD_DUPLICATION, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check sentence with word duplications", dataProvider = "duplSentenceCodeLang")
    void capsSpelledTest(String duplSentence, Integer errorCode, String lang) {
        SpellerDto[][] textDescription = spellerService.checkSentenceWithOptionsAndLang(duplSentence, lang, OPTION_FIND_DUPLICATION);

        new SpellerAssertions(textDescription[0])
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode);
    }
}
