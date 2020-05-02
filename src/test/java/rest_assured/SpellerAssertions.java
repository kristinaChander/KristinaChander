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

    public SpellerAssertions verifyBodyHasCorrectWord(String incorrectWord, String correctWord, Integer errorCode) {
        assertThat(spellerResponse[0]).extracting("word", "s[0]", "code")
                .containsExactly(incorrectWord, correctWord, errorCode);
        return this;
    }
}