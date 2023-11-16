package com.tests.auto_tests_template.steps;

import com.codeborne.selenide.Selectors;
import com.tests.auto_tests_template.utils.*;
import io.cucumber.java.ru.Если;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebElementsSteps {
    private PagesManager pagesManager = ThreadContextHolder.getValue("PagesManager");
    private final Long timeOut = 10L;

    @Если("Подождать появления элемента {string} в течение {long} секунд")
    public void waitElementVisible(String currentElement, Long seconds) {
        WebActions.waitElementVisible(pagesManager.getCurrentPage().getElement(currentElement), seconds);
    }

    @Если("Подождать исчезновения элемента {string} в течение {long} секунд")
    public void waitElementNotVisible(String currentElement, Long seconds) {
        WebActions.waitElementNotVisible(pagesManager.getCurrentPage().getElement(currentElement), seconds);
    }

    @Если("Элемент {string} имеется на странице")
    public void elementVisible(String currentElement) {
        WebActions.waitElementVisible(pagesManager.getCurrentPage().getElement(currentElement), timeOut);
    }

    @Если("Элемент {string} отсутствует на странице")
    public void elementNotVisible(String currentElement) {
        WebActions.waitElementNotVisible(pagesManager.getCurrentPage().getElement(currentElement), timeOut);
    }

    @Если("Кликнуть на элемент {string}")
    public void clickOnElement(String element) {
        WebActions.clickOnElement(pagesManager.getCurrentPage().getElement(element));
    }

    @Если("Кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .click();
    }

    @Если("Ввести в поле {string} значение {string}")
    public void setStringOnElement(String element, String value) {
        WebActions.setStringOnElement(pagesManager.getCurrentPage().getElement(element), value);
    }

    @Если("Ввести в поле {string} значение переменной {string}")
    public void setVariableOnElement(String element, String value) {
        WebActions.setStringOnElement(pagesManager.getCurrentPage().getElement(element),
                ThreadContextHolder.getValue(value));
    }

    @Если("Очистить поле {string}")
    public void clearFiled(String element) {
        pagesManager.getCurrentPage().getElement(element).clear();
    }

    @Если("Установить чекбокс на элементе {string}")
    public void selectCheckboxOnElement(String element) {
        WebActions.setCheckBox(pagesManager.getCurrentPage().getElement(element), true);
    }

    @Если("Убрать чекбокс на элементе {string}")
    public void unselectCheckboxOnElement(String element) {
        WebActions.setCheckBox(pagesManager.getCurrentPage().getElement(element), false);
    }

    @Если("На странице присутствует текст {string}")
    public void textAppearOnThePage(String text) {
        WebActions.textVisibleOnPage(text, timeOut);
    }

    @Если("На странице отсутствует текст {string}")
    public void textVisibleOnPage(String text) {
        WebActions.textNotVisibleOnPage(text, timeOut);
    }

    @Если("Подождать появления текста {string} в течение {long} секунд")
    public void waitTextVisibleOnThePage(String text, Long seconds) {
        WebActions.textVisibleOnPage(text, seconds);
    }

    @Если("Подождать исчезновения текста {string} в течение {long} секунд")
    public void waitTextNotVisibleOnPage(String text, Long seconds) {
        WebActions.textNotVisibleOnPage(text, seconds);
    }

    @Если("Текст элемента {string} содержит: {string}")
    public void elementTextContainsExpectedText(String element, String text) {
        WebActions.elementTextContainsExpectedText(pagesManager.getCurrentPage().getElement(element), text, timeOut);
    }

    @Если("Текст элемента {string} равен: {string}")
    public void elementTextEqualExpectedText(String element, String text) {
        WebActions.elementTextEqualsExpectedText(pagesManager.getCurrentPage().getElement(element), text, timeOut);
    }
}
