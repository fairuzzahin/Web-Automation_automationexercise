package com.automationexercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        String path = "src/test/resources/config.properties";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {

            properties.load(fileInputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties file", e
            );
        }
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {

            throw new RuntimeException(
                    "Property not found or empty: " + key
            );
        }

        return value.trim();
    }

    public static int getInt(String key) {

        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {

        return Boolean.parseBoolean(get(key));
    }
}