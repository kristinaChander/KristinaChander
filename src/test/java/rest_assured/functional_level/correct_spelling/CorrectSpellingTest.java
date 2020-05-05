package rest_assured.functional_level.correct_spelling;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rest_assured.Services.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.functional_level.SetUpFunctionalLevel;
import static rest_assured.Constants.*;

public class CorrectSpellingTest extends SetUpFunctionalLevel {
    @DataProvider
    public Object[][] correctWordAndLang() {
        return new Object[][]{
                {ONE_ENGLISH_WORD_CORRECT_SPELLING, ENGLISH_LANG},
                {ONE_RUSSIAN_WORD_CORRECT_SPELLING, RUSSIAN_LANG},
                {ONE_UKRAINIAN_WORD_CORRECT_SPELLING, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check correctly spelled word", dataProvider = "correctWordAndLang")
    void oneCorrectWordTest(String word, String lang) {
        SpellerDto[] textDescription = spellerService.getSpellingOneWordCheckResult(word, lang);

        new SpellerAssertions(textDescription)
                .verifyEmptyBody();

    }

    @DataProvider
    public Object[][] correctSentenceAndLang() {
        return new Object[][]{
                {SENTENCE_ENGLISH_CORRECT_SPELLING, ENGLISH_LANG},
                {SENTENCE_RUSSIAN_CORRECT_SPELLING, RUSSIAN_LANG},
                {SENTENCE_UKRAINIAN_CORRECT_SPELLING, UKRAINIAN_LANG},
        };
    }

    @Test(description = "check correctly spelled sentence", dataProvider = "correctSentenceAndLang")
    void correctSentenceTest(String sentence, String lang) {
        SpellerDto[][] textDescription = spellerService.getSpellingSentenceCheckResult(sentence, lang);

        new SpellerAssertions(textDescription[0])
                .verifyEmptyBody();

    }
}
