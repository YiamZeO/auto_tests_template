package com.tests.auto_tests_template.steps;

import com.tests.auto_tests_template.utils.PagesManager;
import com.tests.auto_tests_template.utils.ThreadContextHolder;
import com.tests.auto_tests_template.utils.VariableManager;
import io.cucumber.java.ru.Если;

public class VariableSteps {
    private PagesManager pagesManager = ThreadContextHolder.getValue("PagesManager");
    private VariableManager variableManager = new VariableManager();

    @Если("Сохранить значение элемента {string} в переменную {string}")
    public void saveElementValue(String element, String variable){
        variableManager.addVariableValue(variable, pagesManager.getCurrentPage().getElement(element).getOwnText());
    }

    @Если("Значения переменных {string} и {string} равны")
    public void elementsValueIsEqual(String firstElement, String secondElement){
        if (!variableManager.getVariableValue(firstElement)
                .equals(variableManager.getVariableValue(secondElement)))
        {
            throw new RuntimeException("Элементы " + firstElement + " и " + secondElement + " не равны");
        }

    }

    @Если("Значения переменных {string} и {string} не равны")
    public void elementsValueNotEqual(String firstElement, String secondElement){
        if (variableManager.getVariableValue(firstElement)
                .equals(variableManager.getVariableValue(secondElement)))
        {
            throw new RuntimeException("Элементы " + firstElement + " и " + secondElement + " равны");
        }
    }
}
