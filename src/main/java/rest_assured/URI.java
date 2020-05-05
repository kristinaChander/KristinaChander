package rest_assured;

import static rest_assured.GetPropertyUtil.getProperty;

public class URI {
    public static final String DOMAIN = getProperty().getProperty("domain");
    public static final String CHECK_TEXT_ENDPOINT = DOMAIN + "checkText";
    public static final String CHECK_TEXTS_ENDPOINT = DOMAIN + "checkTexts";
}
