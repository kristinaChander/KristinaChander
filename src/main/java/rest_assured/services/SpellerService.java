package rest_assured.services;

import com.google.gson.Gson;
import io.restassured.response.ResponseBody;
import rest_assured.dto.SpellerDto;
import rest_assured.dto.SpellerParamDto;

import java.util.HashMap;

import static rest_assured.URI.CHECK_TEXTS_ENDPOINT;
import static rest_assured.URI.CHECK_TEXT_ENDPOINT;

public class SpellerService {
    private final CommonService commonService = new CommonService();

    public SpellerDto[] getTextSpellerResult(SpellerParamDto params) {
        HashMap<String, Object> param = getParams(params);
        ResponseBody body = commonService.getWithParams(CHECK_TEXT_ENDPOINT, param).getBody();
        return new Gson().fromJson(body.asString(), SpellerDto[].class);
    }

    public SpellerDto[][] getTextsSpellerResult(SpellerParamDto params) {
        HashMap<String, Object> parameters = getParams(params);
        ResponseBody body = commonService.getWithParams(CHECK_TEXTS_ENDPOINT, parameters).getBody();
        return new Gson().fromJson(body.asString(), SpellerDto[][].class);
    }

    private HashMap<String, Object> getParams(SpellerParamDto params) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("text", params.getText());
        paramsMap.put("lang", params.getLang());
        paramsMap.put("options", params.getOptions());
        return paramsMap;
    }
}
