package rest_assured;

public class URI {

    public static final String DOMAIN = GetPropertyUtil.getProperties().getProperty("domain") ;
    public static final String CHECK_TEXT_ENDPOINT = DOMAIN + GetPropertyUtil.getProperties().getProperty("checkTextEndPoint");
    public static final String CHECK_TEXTS_ENDPOINT = DOMAIN + GetPropertyUtil.getProperties().getProperty("checkTextsEndPoint");
}
