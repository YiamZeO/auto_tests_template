package com.tests.auto_tests_template.pages;

import com.codeborne.selenide.SelenideElement;
import com.tests.auto_tests_template.utils.annotations.Element;
import com.tests.auto_tests_template.utils.annotations.Page;

import static com.codeborne.selenide.Selenide.$;

@Page("ЕИРЦ страница входа")
public class EircAuthPage {
    @Element("Кнопка входа")
    SelenideElement inButton = $("button[class^='thuiButton']");
    @Element("Поле логина")
    SelenideElement loginField = $("input[id='login']");
    @Element("Поле пароля")
    SelenideElement passwordField = $("input[id='password']");
}
