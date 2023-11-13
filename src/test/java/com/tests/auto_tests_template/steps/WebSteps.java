package com.tests.auto_tests_template.steps;

import com.codeborne.selenide.Selectors;
import com.tests.auto_tests_template.utils.PagesManager;
import com.tests.auto_tests_template.utils.VariableManager;
import com.tests.auto_tests_template.utils.WebActions;
import com.tests.auto_tests_template.utils.WebPage;
import io.cucumber.java.ru.Если;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private WebPage currentPage;
    private PagesManager pagesManager = new PagesManager("com.tests.auto_tests_template.pages");
    private VariableManager variableManager = new VariableManager();
    private final Long timeOut = 10L;

    @Если("Открыть url {string}")
    public void openUrl(String url) {
        open(url);
    }

    @Если("Инициализация страницы {string}")
    public void pageInit(String pageName) {
        currentPage = pagesManager.getPage(pageName);
    }

    @Если("Подождать появления элемента {string} в течение {long} секунд")
    public void waitElementVisible(String currentElement, Long seconds) {
        WebActions.waitElementVisible(currentPage.getElement(currentElement), seconds);
    }

    @Если("Подождать исчезновения элемента {string} в течение {long} секунд")
    public void waitElementNotVisible(String currentElement, Long seconds) {
        WebActions.waitElementNotVisible(currentPage.getElement(currentElement), seconds);
    }

    @Если("Элемент {string} имеется на странице")
    public void elementVisible(String currentElement) {
        WebActions.waitElementVisible(currentPage.getElement(currentElement), timeOut);
    }

    @Если("Элемент {string} отсутствует на странице")
    public void elementNotVisible(String currentElement) {
        WebActions.waitElementNotVisible(currentPage.getElement(currentElement), timeOut);
    }

    @Если("Кликнуть на элемент {string}")
    public void clickOnElement(String element) {
        WebActions.clickOnElement(currentPage.getElement(element));
    }

    @Если("Кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .click();
    }

    @Если("Ввести в поле {string} значение {string}")
    public void setStringOnElement(String element, String value) {
        WebActions.setStringOnElement(currentPage.getElement(element), value);
    }

    @Если("Очистить поле {string}")
    public void clearFiled(String element) {
        currentPage.getElement(element).clear();
    }

    @Если("Установить чекбокс на элементе {string}")
    public void selectCheckboxOnElement(String element) {
        WebActions.setCheckBox(currentPage.getElement(element), true);
    }

    @Если("Убрать чекбокс на элементе {string}")
    public void unselectCheckboxOnElement(String element) {
        WebActions.setCheckBox(currentPage.getElement(element), false);
    }

    @Если("Сохранить значение элемента {string} в переменную {string}")
    public void saveElementValue(String element, String variable){
        variableManager.addVariableValue(variable, currentPage.getElement(element).getOwnText());
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

    @Если("На странице присутствует текст {string}")
    public void textAppearOnThePage(String text) {
        WebActions.textVisibleOnPage(text, timeOut);
    }

    @Если("На странице отсутствует текст {string}")
    public void textVisibleOnPage(String text) {
        WebActions.textNotVisibleOnPage(text, timeOut);
    }

    @Если("Подождать появления текста {string} в течении {long} секунд")
    public void waitTextVisibleOnThePage(String text, Long seconds) {
        WebActions.textVisibleOnPage(text, seconds);
    }

    @Если("Подождать исчезновения текста {string} в течении {long} секунд")
    public void waitTextNotVisibleOnPage(String text, Long seconds) {
        WebActions.textNotVisibleOnPage(text, seconds);
    }

    @Если("Текст элемента {string} содержит: {string}")
    public void elementTextContainsExpectedText(String element, String text) {
        WebActions.elementTextContainsExpectedText(currentPage.getElement(element), text, timeOut);
    }

    @Если("Текст элемента {string} равен: {string}")
    public void elementTextEqualExpectedText(String element, String text) {
        WebActions.elementTextEqualsExpectedText(currentPage.getElement(element), text, timeOut);
    }
}
