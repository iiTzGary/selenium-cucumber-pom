package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static final String CONFIG_PATH = "src/main/resources/config.json";
    private static JsonNode configNode;

    // loads configuration file when the class is instanciated
    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            configNode = objectMapper.readTree(new File(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + e.getMessage());
        }
    }

    // Method to get a string value from config.json
    public static String getString(String key) {
        return configNode.get(key).asText();
    }

    // Method to get an integer value from config.json
    public static int getInt(String key) {
        return configNode.get(key).asInt();
    }

    // Method to get a boolean value from config.json
    public static boolean getBoolean(String key) {
        return configNode.get(key).asBoolean();
    }

    // Method to get browser-specific configurations
    public static JsonNode getBrowserConfig(String browser) {
        return configNode.get(browser.toLowerCase());
    }
}
