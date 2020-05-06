package rest_assured.speller_service_description;

public enum Languages {

    ENGLISH("en"),
    RUSSIAN("ru"),
    UKRAINIAN("uk");

    private final String value;

    Languages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
