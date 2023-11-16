package com.tests.auto_tests_template.steps;

import com.tests.auto_tests_template.utils.PagesManager;
import com.tests.auto_tests_template.utils.ThreadContextHolder;
import io.cucumber.java.ru.Если;

public class VariableSteps {
    private PagesManager pagesManager = ThreadContextHolder.getValue("PagesManager");

    @Если("Сохранить значение элемента {string} в переменную {string}")
    public void saveElementValue(String element, String variable){
        ThreadContextHolder.putValue(variable, pagesManager.getCurrentPage().getElement(element).getOwnText());
    }

    @Если("Значения переменных {string} и {string} равны")
    public void elementsValueIsEqual(String firstElement, String secondElement){
        if (!ThreadContextHolder.getValue(firstElement)
                .equals(ThreadContextHolder.getValue(secondElement)))
        {
            throw new RuntimeException("[Ошибка] Элементы \"" + firstElement + "\" и \"" + secondElement + "\" не равны: "
                    + ThreadContextHolder.getValue(firstElement) + " != " + ThreadContextHolder.getValue(secondElement));
        }

    }

    @Если("Значения переменных {string} и {string} не равны")
    public void elementsValueNotEqual(String firstElement, String secondElement){
        if (ThreadContextHolder.getValue(firstElement)
                .equals(ThreadContextHolder.getValue(secondElement)))
        {
            throw new RuntimeException("[Ошибка] Элементы \"" + firstElement + "\" и \"" + secondElement + "\" равны: "
                    + ThreadContextHolder.getValue(firstElement) + " == " + ThreadContextHolder.getValue(secondElement));
        }
    }
}
