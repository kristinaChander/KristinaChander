package rest_assured.constants_and_utils;

import static rest_assured.constants_and_utils.GetPropertyUtil.getProperties;

public class URI {
    public static final String DOMAIN = getProperties().getProperty("domain");
    public static final String CHECK_TEXT_ENDPOINT = DOMAIN + "checkText";
    public static final String CHECK_TEXTS_ENDPOINT = DOMAIN + "checkTexts";
}
