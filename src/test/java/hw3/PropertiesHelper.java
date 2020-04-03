package hw3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    private Properties properties;

    public PropertiesHelper(String fileName) {
        this.properties = readFromFile(fileName);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private Properties readFromFile(String fileName) {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Can't open property file " + fileName, e);
        }
        return properties;
    }
}