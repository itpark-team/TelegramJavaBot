package com.mytgbot.statemachine.model;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {

    private Map<String, Object> keyValuePairs;

    public DataStorage() {
        keyValuePairs = new HashMap<>();
    }

    public void add(String key, Object value) {
        keyValuePairs.put(key, value);
    }

    public void remove(String key) {
        keyValuePairs.remove(key);
    }

    public Object get(String key) {
        return keyValuePairs.get(key);
    }
}
