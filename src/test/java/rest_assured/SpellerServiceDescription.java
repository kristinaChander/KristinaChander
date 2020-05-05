package rest_assured;

import static rest_assured.GetPropertyUtil.getPropertyAsInteger;
import static rest_assured.GetPropertyUtil.getPropertyAsString;

public class SpellerServiceDescription {


    public static final String ENGLISH_LANG = "en";
    public static final String RUSSIAN_LANG = "ru";
    public static final String UKRAINIAN_LANG = "uk";

    public static final Integer OPTION_IGNORE_CAPITALIZATION = 512;
    public static final Integer OPTION_IGNORE_DIGITS = 2;
    public static final Integer OPTION_FIND_DUPLICATION = 8;

    public static final Integer ERROR_CODE_CAPS = 3;
    public static final Integer ERROR_CODE_WORD_DUPLICATION = 2;
    public static final Integer ERROR_CODE_NOT_IN_THE_DICTIONARY = 1;
}
