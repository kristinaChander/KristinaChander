package rest_assured;

import static org.assertj.core.api.Assertions.assertThat;

public class SpellerAssertions {

    private SpellerDto[] spellerResponse;

    public SpellerAssertions(SpellerDto[] spellerResponse) {
        this.spellerResponse = spellerResponse;
    }

    public SpellerAssertions verifyEmptyBody() {
        assertThat(spellerResponse).isEmpty();
        return this;
    }

    public SpellerAssertions verifyNotEmptyBody() {
        assertThat(spellerResponse).isNotEmpty();
        return this;
    }

    public SpellerAssertions verifyBodyHasErrorCode(Integer errorCode) {
        assertThat(spellerResponse[0]).extracting( "code").isSameAs(errorCode);
        return this;
    }
    public SpellerAssertions verifyBodyHasIncorrectWord(String incorrectWord) {
        assertThat(spellerResponse[0]).extracting("word").isEqualTo(incorrectWord);
        return this;
    }

    public SpellerAssertions verifyBodyHasCorrectedWord(String correctWord) {
        assertThat(spellerResponse[0]).extracting( "s").isEqualToComparingOnlyGivenFields(correctWord);
        return this;
    }
}