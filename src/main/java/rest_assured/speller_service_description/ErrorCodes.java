package rest_assured.speller_service_description;

public enum ErrorCodes {
    CAPS_ERROR(3),
    WORD_DUPLICATION_ERROR(2),
    NOT_IN_THE_DICTIONARY_ERROR(1);

    private final Integer value;

    ErrorCodes(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
