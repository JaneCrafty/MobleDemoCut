package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.Enums.AndroidConfigFile;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Prints the difference between remote_config.json and all other configs in android configs folder
 * Usage: just launch the main method
 */
public class ConfigParser {
    public static void main(String[] args) throws JSONException {
        Map<String, Object> defaultConfig = getDefaultConfigPath();

        File directory = new File("AndroidMainConfig");
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.getName().equals("remote_config.json") || !file.getName().contains(".json")) {
                continue;
            }

            System.out.println("Parsing config file: " + file.getName());
            Map<String, Object> currentConfig = getDefaultConfigPath(file.getPath());
            configDifference(defaultConfig, currentConfig);
        }
    }

    private static void configDifference(Map<String, Object> defaultConfig, Map<String, Object> config) {
        System.out.println("Difference between default and current config is:");

        List<String> added = new LinkedList<>();
        config.keySet().stream()
                .filter(key -> !defaultConfig.containsKey(key))
                .forEach(added::add);
        if (!added.isEmpty()) {
            System.out.println("Added keys are:");
            added.forEach(System.out::println);
            System.out.println();
        }

        List<String> removed = new LinkedList<>();
        defaultConfig.keySet().stream()
                .filter(key -> !config.containsKey(key))
                .forEach(removed::add);
        if (!removed.isEmpty()) {
            System.out.println("Removed keys are:");
            removed.forEach(System.out::println);
        }

        List<String> changed = new LinkedList<>();
        config.keySet().stream()
                .filter(key -> defaultConfig.containsKey(key) && !defaultConfig.get(key).equals(config.get(key)))
                .forEach(key -> changed.add("Key: " + key +
                        "\n  Default Value: " + defaultConfig.get(key) +
                        "\n  Current Value: " + config.get(key)));
        if (!changed.isEmpty()) {
            System.out.println("Changed values are:");
            changed.forEach(System.out::println);
            System.out.println();
        }
        if (changed.isEmpty() && added.isEmpty() && removed.isEmpty()) {
            System.out.println("Configs are identical\n");
        }
    }

    private static Map<String, Object> getDefaultConfigPath(String configPath) throws JSONException {
        Map<String, Object> result = new HashMap<>();
        JSONArray configArray = showConfig(configPath).getJSONArray("config");
        for (int i = 0; i < configArray.length(); i++) {
            JSONObject el = configArray.getJSONObject(i);
            String key = (String) el.get("key");
            Object value = el.get("value");
            result.put(key, value);
        }
        return result;
    }

    private static Map<String, Object> getDefaultConfigPath() throws JSONException {
        return getDefaultConfigPath(AndroidConfigFile.DEFAULT.getFilePath());
    }

    private static JSONObject showConfig(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return new JSONObject(content.toString());
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}