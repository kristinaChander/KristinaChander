package rest_assured.services;

import org.assertj.core.api.Assertions;
import rest_assured.dTO.SpellerDto;

public class SpellerAssertions {
    private SpellerDto[] spellerResponse;

    public SpellerAssertions(SpellerDto[] spellerResponse) {
        this.spellerResponse = spellerResponse;
    }

    public SpellerAssertions verifyEmptyBody() {
        Assertions.assertThat(spellerResponse).isEmpty();
        return this;
    }

    public SpellerAssertions verifyNotEmptyBody() {
        Assertions.assertThat(spellerResponse).isNotEmpty();
        return this;
    }

    public SpellerAssertions verifyBodyHasErrorCode(Integer errorCode) {
        Assertions.assertThat(spellerResponse[0]).extracting( "code").isSameAs(errorCode);
        return this;
    }
    public SpellerAssertions verifyBodyHasIncorrectWord(String incorrectWord) {
        Assertions.assertThat(spellerResponse[0]).extracting("word").isEqualTo(incorrectWord);
        return this;
    }

    public SpellerAssertions verifyBodyHasCorrectedWord(String correctWord) {
        Assertions.assertThat(spellerResponse[0]).extracting( "s").isEqualToComparingOnlyGivenFields(correctWord);
        return this;
    }
}