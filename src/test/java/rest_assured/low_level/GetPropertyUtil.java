package rest_assured.low_level;

import lombok.SneakyThrows;

import java.util.Properties;

public final class GetPropertyUtil {

    private GetPropertyUtil() {}

    @SneakyThrows
    public static Properties getProperties(){
        Properties properties = new Properties();
        String propertyFilePath  = "rest_assured/yaSpeller.properties";
        properties.load(GetPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath));
        return properties;
    }
}
