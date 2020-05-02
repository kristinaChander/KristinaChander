package rest_assured;

public class Constants {
    public static final String ONE_ENGLISH_WORD_WRONG_SPELLING = "helo";
    public static final String  ONE_RUSSIAN_WORD_WRONG_SPELLING = "прювет";
    public static final String  ONE_UKRANIAN_WORD_WRONG_SPELLING = "прривіт";

    public static final String ONE_ENGLISH_WORD_CORRECT_SPELLING = "hello";
    public static final String ONE_RUSSIAN_WORD_CORRECT_SPELLING = "привет";
    public static final String ONE_UKRANIAN_WORD_CORRECT_SPELLING = "привіт";



    public static final String SENTENCE_ENGLISH_WRONG_SPELLING = "catt is naice";
    public static final String SENTENCE_RUSSIAN_WRONG_SPELLING = "Кажддый человввек илмеет прао на обршзование";
    public static final String SENTENCE_UKRANIAN_WRONG_SPELLING = "Кожа лдина ioмає прppво на оoсвіту";

    public static final String SENTENCE_ENGLISH_CORRECT_SPELLING = "Cat is nice";
    public static final String SENTENCE_RUSSIAN_CORRECT_SPELLING = "Каждый человек имеет право на образование";
    public static final String SENTENCE_UKRANIAN_CORRECT_SPELLING = "Кожна людина має право на освіту";


    public static final String ENGLISH_WORD_WITH_CAPS = "hELLO";
    public static final String RUSSIAN_WORD_WITH_CAPS = "пРИВет";
    public static final String UKRANIAN_WORD_WITH_CAPS = "пРИВіт";

    public static final String WORD_WITH_DIGITS = "7688799$";
    public static final String WORD_WITH_DIGITS2 = "21-09-1978";
    public static final String WORD_WITH_DIGITS3 = "+7-980-765-43-21";

    public static final String ENGLISH_LANG = GetPropertyUtil.getProperties().getProperty("englishLang");
    public static final String RUSSIAN_LANG = GetPropertyUtil.getProperties().getProperty("russianLang");
    public static final String UKRANIAN_LANG = GetPropertyUtil.getProperties().getProperty("ukranianLang");

    public static final String SENTENCE_ENGLISH_DUPLICATION = "hello hello how how how are you";
    public static final String SENTENCE_RUSSIAN_DUPLICATION = "привет привет привет";
    public static final String SENTENCE_UKRANIAN_DUPLICATION = "привіт привіт привіт привіт";

    public static final Integer OPTION_IGNORE_CAPITALIZATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionIgnoreCapitalization"));
    public static final Integer OPTION_IGNORE_DIGITS = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionIgnoreDigits"));
    public static final Integer OPTION_FIND_DUPLICATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionFindDuplication"));

    public static final Integer ERROR_CODE_CAPS = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeCaps"));
    public static final Integer ERROR_CODE_WORD_DUPLICATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeWordDuplication"));
    public static final Integer ERROR_CODE_NOT_IN_THE_DICTIONARY = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeNotInTheDictionary"));




}
