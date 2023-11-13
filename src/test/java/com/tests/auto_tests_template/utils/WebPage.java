package com.tests.auto_tests_template.utils;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

public class WebPage {
    private Map<String, SelenideElement> elementsMap = new HashMap<>();

    public SelenideElement getElement(String name) {
        return (SelenideElement) elementsMap.get(name);
    }

    public void addElement(String name, SelenideElement element){
        elementsMap.put(name, element);
    }
}
