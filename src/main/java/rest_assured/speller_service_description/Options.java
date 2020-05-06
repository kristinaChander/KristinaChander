package rest_assured.speller_service_description;

public enum Options {
    IGNORE_CAPITALIZATION(512),
    IGNORE_DIGITS(2),
    FIND_DUPLICATION(8);

    private Integer value;

    Options(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
