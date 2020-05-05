package rest_assured;

import static rest_assured.GetPropertyUtil.getPropertyAsString;

public class URI {
    public static final String DOMAIN = getPropertyAsString("domain");
    public static final String CHECK_TEXT_ENDPOINT = DOMAIN + getPropertyAsString("checkTextEndPoint");
    public static final String CHECK_TEXTS_ENDPOINT = DOMAIN + getPropertyAsString("checkTextsEndPoint");
}
