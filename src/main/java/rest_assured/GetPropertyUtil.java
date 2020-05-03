package rest_assured;

import lombok.SneakyThrows;

import java.util.Properties;

public final class GetPropertyUtil {

    private GetPropertyUtil() {}

    private static final Properties PROPS = loadProperties();

    @SneakyThrows
    public static Properties loadProperties(){
        Properties properties = new Properties();
        String propertyFilePath  = "rest_assured/yaSpeller.properties";
        properties.load(GetPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath));
        return properties;
    }

    public static String getPropertyAsString(String propertyKey){
        return PROPS.getProperty(propertyKey);
    }

    public static Integer getPropertyAsInteger(String propertyKey){
        return Integer.parseInt(getPropertyAsString(propertyKey));
    }
}
