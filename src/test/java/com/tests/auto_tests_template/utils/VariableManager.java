package com.tests.auto_tests_template.utils;

import java.util.HashMap;
import java.util.Map;

public class VariableManager {
    private final Map<String, Object> variableMap = new HashMap<>();

    public <T> T getVariableValue(String name) {
        return (T) variableMap.get(name);
    }

    public void addVariableValue(String name, Object value) {
        variableMap.put(name, value);
    }
}
