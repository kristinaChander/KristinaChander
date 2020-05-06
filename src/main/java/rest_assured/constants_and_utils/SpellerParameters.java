package rest_assured.constants_and_utils;

public enum SpellerParameters {
    LANGUAGE ("lang"),
    TEXT ("text"),
    OPTIONS ("options");

    private final String value;

    SpellerParameters(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
