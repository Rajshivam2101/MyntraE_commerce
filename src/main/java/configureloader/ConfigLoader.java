package configureloader;


import enumeration.ConfigKey;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("configureloader/config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            PROPERTIES.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load config.properties", e
            );
        }
    }

    public static String get(ConfigKey key) {
        String value = PROPERTIES.getProperty(key.getKey());

        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Missing configuration value for key: " + key
            );
        }
        return value;
    }
}