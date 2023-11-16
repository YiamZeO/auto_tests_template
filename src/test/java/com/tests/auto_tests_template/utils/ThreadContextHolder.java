package com.tests.auto_tests_template.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadContextHolder {
    private static final ThreadLocal<Map<String, Object>> CURRENT_THREAD = new ThreadLocal<>();

    private static Map<String, Object> getThread() {
        Map<String, Object> vault = CURRENT_THREAD.get();
        if (vault == null) {
            vault = new HashMap<>();
            CURRENT_THREAD.set(vault);
        }
        return vault;
    }

    public static Map<String, Object> asMap() {
        return getThread();
    }

    public static void putValue(String key, Object value) {
        getThread().put(key, value);
    }

    public static <T> T getValue(String key) {
        return (T) getThread().get(key);
    }

    public static <T> T remove(String key) {
        return (T) getThread().remove(key);
    }
}
