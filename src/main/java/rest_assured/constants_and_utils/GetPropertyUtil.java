package rest_assured.constants_and_utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GetPropertyUtil {

    @SneakyThrows
    public static Properties getProperties() {
        Properties properties = new Properties();
        String propertyFilePath = "rest_assured/yaSpeller.properties";
        properties.load(GetPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilePath));
        return properties;
    }
}
