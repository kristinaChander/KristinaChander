package rest_assured.Services;

import com.google.gson.Gson;
import io.restassured.response.ResponseBody;
import rest_assured.SpellerDto;
import java.util.HashMap;
import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class SpellerService {
    private final CommonService commonService = new CommonService();

    public SpellerDto[] checkOneWordWithOptions(String text, Integer option) {
        return checkOneWordWithOptionsAndLang(text,null,option);
    }

    public SpellerDto[] checkOneWordWithLang(String text, String lang) {
        return getTextSpellerResultOneWord(text, lang, null);
    }

    public SpellerDto[] checkOneWordWithOptionsAndLang(String text, String lang, Integer options) {
        return getTextSpellerResultOneWord(text, lang, options);
    }

    public SpellerDto[][] checkSentenceWithLang(String text, String lang) {
        return getTextsSpellerResultSentence(text, lang, null);
    }

    public SpellerDto[][] checkSentenceWithOptionsAndLang(String text, String lang, Integer options) {
        return getTextsSpellerResultSentence(text, lang, options);
    }

    private SpellerDto[] getTextSpellerResultOneWord(String text, String lang, Integer options) {
        HashMap<String, Object> params = getParams(text, lang, options);
        ResponseBody body = commonService.getWithParams(CHECK_TEXT_ENDPOINT, params).getBody();
        return new Gson().fromJson(body.asString(),SpellerDto[].class);
    }

    private SpellerDto[][] getTextsSpellerResultSentence(String text, String lang, Integer options) {
        HashMap<String, Object> params = getParams(text, lang, options);
        ResponseBody body = commonService.getWithParams(CHECK_TEXTS_ENDPOINT, params).getBody();
        return new Gson().fromJson(body.asString(), SpellerDto[][].class);
    }

    private HashMap<String, Object> getParams(String text, String lang, Integer options) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("text", text);
        params.put("lang", lang);
        params.put("options", options);
        return params;
    }
}
