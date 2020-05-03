package rest_assured;

public class Constants {
    public static final String ONE_ENGLISH_WORD_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("oneEnglishWordWrongSpelling");
    public static final String ONE_RUSSIAN_WORD_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("oneRussianWordWrongSpelling");
    public static final String ONE_UKRAINIAN_WORD_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("oneUkrainianWordWrongSpelling");

    public static final String ONE_ENGLISH_WORD_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("oneEnglishWordCorrectSpelling");
    public static final String ONE_RUSSIAN_WORD_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("oneRussianWordCorrectSpelling");
    public static final String ONE_UKRAINIAN_WORD_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("oneUkrainianWordCorrectSpelling");

    public static final String SENTENCE_ENGLISH_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceEnglishWrongSpelling");
    public static final String SENTENCE_RUSSIAN_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceRussianWrongSpelling");
    public static final String SENTENCE_UKRAINIAN_WRONG_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceUkrainianWrongSpelling");

    public static final String SENTENCE_ENGLISH_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceEnglishCorrectSpelling");
    public static final String SENTENCE_RUSSIAN_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceRussianCorrectSpelling");
    public static final String SENTENCE_UKRAINIAN_CORRECT_SPELLING = GetPropertyUtil.getProperties().getProperty("sentenceUkrainianCorrectSpelling");

    public static final String ENGLISH_WORD_WITH_CAPS = GetPropertyUtil.getProperties().getProperty("englishWordWithCaps");
    public static final String RUSSIAN_WORD_WITH_CAPS = GetPropertyUtil.getProperties().getProperty("russianWordWithCaps");
    public static final String UKRAINIAN_WORD_WITH_CAPS = GetPropertyUtil.getProperties().getProperty("ukrainianWordWithCaps");

    public static final String SENTENCE_ENGLISH_DUPLICATION = GetPropertyUtil.getProperties().getProperty("sentenceEnglishDuplication");
    public static final String SENTENCE_RUSSIAN_DUPLICATION = GetPropertyUtil.getProperties().getProperty("sentenceRussianDuplication");
    public static final String SENTENCE_UKRAINIAN_DUPLICATION = GetPropertyUtil.getProperties().getProperty("sentenceUkrainianDuplication");

    public static final String WORD_WITH_DIGITS = "7688799$";
    public static final String WORD_WITH_DIGITS2 = "21-09-1978";
    public static final String WORD_WITH_DIGITS3 = "+7-980-765-43-21";

    public static final String ENGLISH_LANG = GetPropertyUtil.getProperties().getProperty("englishLang");
    public static final String RUSSIAN_LANG = GetPropertyUtil.getProperties().getProperty("russianLang");
    public static final String UKRAINIAN_LANG = GetPropertyUtil.getProperties().getProperty("UKRAINIANLang");

    public static final Integer OPTION_IGNORE_CAPITALIZATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionIgnoreCapitalization"));
    public static final Integer OPTION_IGNORE_DIGITS = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionIgnoreDigits"));
    public static final Integer OPTION_FIND_DUPLICATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("optionFindDuplication"));

    public static final Integer ERROR_CODE_CAPS = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeCaps"));
    public static final Integer ERROR_CODE_WORD_DUPLICATION = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeWordDuplication"));
    public static final Integer ERROR_CODE_NOT_IN_THE_DICTIONARY = Integer.parseInt(GetPropertyUtil.getProperties().getProperty("errorCodeNotInTheDictionary"));
}
