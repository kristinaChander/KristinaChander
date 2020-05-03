package rest_assured;

import static rest_assured.GetPropertyUtil.getPropertyAsInteger;
import static rest_assured.GetPropertyUtil.getPropertyAsString;

public class Constants {
    public static final String ONE_ENGLISH_WORD_WRONG_SPELLING = getPropertyAsString("oneEnglishWordWrongSpelling");
    public static final String ONE_RUSSIAN_WORD_WRONG_SPELLING = getPropertyAsString("oneRussianWordWrongSpelling");
    public static final String ONE_UKRAINIAN_WORD_WRONG_SPELLING = getPropertyAsString("oneUkrainianWordWrongSpelling");

    public static final String ONE_ENGLISH_WORD_CORRECT_SPELLING = getPropertyAsString("oneEnglishWordCorrectSpelling");
    public static final String ONE_RUSSIAN_WORD_CORRECT_SPELLING = getPropertyAsString("oneRussianWordCorrectSpelling");
    public static final String ONE_UKRAINIAN_WORD_CORRECT_SPELLING = getPropertyAsString("oneUkrainianWordCorrectSpelling");

    public static final String SENTENCE_ENGLISH_WRONG_SPELLING = getPropertyAsString("sentenceEnglishWrongSpelling");
    public static final String SENTENCE_RUSSIAN_WRONG_SPELLING = getPropertyAsString("sentenceRussianWrongSpelling");
    public static final String SENTENCE_UKRAINIAN_WRONG_SPELLING = getPropertyAsString("sentenceUkrainianWrongSpelling");

    public static final String SENTENCE_ENGLISH_CORRECT_SPELLING = getPropertyAsString("sentenceEnglishCorrectSpelling");
    public static final String SENTENCE_RUSSIAN_CORRECT_SPELLING = getPropertyAsString("sentenceRussianCorrectSpelling");
    public static final String SENTENCE_UKRAINIAN_CORRECT_SPELLING = getPropertyAsString("sentenceUkrainianCorrectSpelling");

    public static final String ENGLISH_WORD_WITH_CAPS = getPropertyAsString("englishWordWithCaps");
    public static final String RUSSIAN_WORD_WITH_CAPS = getPropertyAsString("russianWordWithCaps");
    public static final String UKRAINIAN_WORD_WITH_CAPS = getPropertyAsString("ukrainianWordWithCaps");

    public static final String SENTENCE_ENGLISH_DUPLICATION = getPropertyAsString("sentenceEnglishDuplication");
    public static final String SENTENCE_RUSSIAN_DUPLICATION = getPropertyAsString("sentenceRussianDuplication");
    public static final String SENTENCE_UKRAINIAN_DUPLICATION = getPropertyAsString("sentenceUkrainianDuplication");

    public static final String WORD_WITH_DIGITS = getPropertyAsString("wordWithDigits");
    public static final String WORD_WITH_DIGITS2 = getPropertyAsString("wordWithDigits2");
    public static final String WORD_WITH_DIGITS3 =  getPropertyAsString("wordWithDigits3");

    public static final String ENGLISH_LANG = getPropertyAsString("englishLang");
    public static final String RUSSIAN_LANG = getPropertyAsString("russianLang");
    public static final String UKRAINIAN_LANG = getPropertyAsString("UKRAINIANLang");

    public static final Integer OPTION_IGNORE_CAPITALIZATION = getPropertyAsInteger("optionIgnoreCapitalization");
    public static final Integer OPTION_IGNORE_DIGITS = getPropertyAsInteger("optionIgnoreDigits");
    public static final Integer OPTION_FIND_DUPLICATION = getPropertyAsInteger("optionFindDuplication");

    public static final Integer ERROR_CODE_CAPS = getPropertyAsInteger("errorCodeCaps");
    public static final Integer ERROR_CODE_WORD_DUPLICATION = getPropertyAsInteger("errorCodeWordDuplication");
    public static final Integer ERROR_CODE_NOT_IN_THE_DICTIONARY = getPropertyAsInteger("errorCodeNotInTheDictionary");
}
