package rest_assured.functional_level.incorrect_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.dto.SpellerDto;
import rest_assured.dto.SpellerParamDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import rest_assured.services.SpellerAssertions;

import static rest_assured.TestData.*;
import static rest_assured.speller_service_description.ErrorCodes.WORD_DUPLICATION_ERROR;
import static rest_assured.speller_service_description.Languages.*;
import static rest_assured.speller_service_description.Options.FIND_DUPLICATION;

public class WordDuplicationTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] duplSentenceCodeLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_DUPLICATION, WORD_DUPLICATION_ERROR.getValue(), ENGLISH.getValue()},
                {SENTENCE_RUSSIAN_DUPLICATION, WORD_DUPLICATION_ERROR.getValue(), RUSSIAN.getValue()},
                {SENTENCE_UKRAINIAN_DUPLICATION, WORD_DUPLICATION_ERROR.getValue(), UKRAINIAN.getValue()},
        };
    }

    @Test(description = "check sentence with word duplications", dataProvider = "duplSentenceCodeLang")
    void capsSpelledTest(String duplSentence, Integer errorCode, String lang) {
        SpellerDto[][] textDescription = spellerService.getTextsSpellerResult(SpellerParamDto.builder()
                .text(duplSentence)
                .lang(lang)
                .options(FIND_DUPLICATION.getValue())
                .build());

        new SpellerAssertions(textDescription[0])
                .verifyNotEmptyBody()
                .verifyBodyHasErrorCode(errorCode);
    }
}
