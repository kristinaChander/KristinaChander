package rest_assured;

import io.restassured.response.ResponseBody;

import java.util.HashMap;

import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class SpellerService {

    private final CommonService commonService = new CommonService();

    public SpellerDto[] getSpellingOneWordCheckResult(String text,Integer option) {
        return getSpellingOneWordCheckResult(text,null,option);
    }

    public SpellerDto[] getSpellingOneWordCheckResult(String text, String lang) {
        return getTextSpellerResult(text, lang, null);
    }

    public SpellerDto[] getSpellingOneWordCheckResult(String text, String lang, Integer options) {
        return getTextSpellerResult(text, lang, options);
    }

    public SpellerDto[][] getSpellingSentenceCheckResult(String text, String lang) {
        return getTextsSpellerResult(text, lang, null);
    }

    public SpellerDto[][] getSpellingSentenceCheckResult(String text) {
        return getTextsSpellerResult(text, null, null);
    }

    public SpellerDto[][] getSpellingSentenceCheckResult(String text, Integer options) {
        return getTextsSpellerResult(text, null, options);
    }
    public SpellerDto[][] getSpellingSentenceCheckResult(String text, String lang, Integer options) {
        return getTextsSpellerResult(text, lang, options);
    }

    private SpellerDto[] getTextSpellerResult(String text, String lang, Integer options) {
        HashMap<String, Object> params = getParams(text, lang, options);
        ResponseBody body = commonService.getWithParams(CHECK_TEXT_ENDPOINT, params).getBody();
        return body.as(SpellerDto[].class);
    }

    private SpellerDto[][] getTextsSpellerResult(String text, String lang, Integer options) {
        HashMap<String, Object> params = getParams(text, lang, options);
        ResponseBody body = commonService.getWithParams(CHECK_TEXTS_ENDPOINT, params).getBody();
        return body.as(SpellerDto[][].class);
    }

    private HashMap<String, Object> getParams(String text, String lang, Integer options) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("text", text);
        params.put("lang", lang);
        params.put("options", options);
        return params;
    }
}
