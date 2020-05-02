package rest_assured.functional_level;

import org.assertj.core.api.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rest_assured.SpellerAssertions;
import rest_assured.SpellerDto;
import rest_assured.SpellerService;
import rest_assured.low_level.GetPropertyUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class CorrectSpellingTest {

    private SpellerService spellerService;

    @BeforeMethod
    public void setUp() {
        spellerService = new SpellerService();
    }

    @Test(description = "check correctly spelled word")
    void oneCorrectWordTest() {
        String text = "hello";

        SpellerDto[] textDescription = spellerService.getSpellingOneWordCheckResult(text, GetPropertyUtil.getProperties().getProperty("englishLang"));

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription);
        spellerAssertions.verifyEmptyBody();
    }

    @Test(description = "check correctly spelled sentence")
    void correctSentenceTest() {
        String text = "hello how are you";

        SpellerDto[][] textDescription = spellerService.getSpellingSentenceCheckResult(text, GetPropertyUtil.getProperties().getProperty("englishLang"));

        SpellerAssertions spellerAssertions = new SpellerAssertions(textDescription[0]);
        spellerAssertions.verifyEmptyBody();
    }



//        assertThat(10)
//                .isLessThan(13)
//                .isGreaterThan(12);
//
//        org.assertj.core.api.Condition<CountryDto> russia = new Condition<>(
//                m -> m.getName().equals("Russia"), "name equal Russia");
//        org.assertj.core.api.Assertions.assertThat(countries[0]).is(russia);
//
//        assertThat(countries)
//                .as("what is happened there")
//                .isEmpty();
}
