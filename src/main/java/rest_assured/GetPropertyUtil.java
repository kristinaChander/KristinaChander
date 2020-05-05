package rest_assured;

import lombok.SneakyThrows;
import java.util.Properties;

public final class GetPropertyUtil {
    private GetPropertyUtil() {}

    @SneakyThrows
    public static Properties getProperty(){
        Properties properties = new Properties();
        String propertyFilePath  = "rest_assured/yaSpeller.properties";
        properties.load(GetPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath));
        return properties;
    }
}
