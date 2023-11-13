package com.tests.auto_tests_template.pages;

import com.codeborne.selenide.SelenideElement;
import com.tests.auto_tests_template.utils.annotations.Element;
import com.tests.auto_tests_template.utils.annotations.Page;

import static com.codeborne.selenide.Selenide.$;

@Page("Страница операции")
public class EircOperationPage {
    @Element("Кнопка выгрузки сообщений")
    public SelenideElement buttonPrimary2 = $("button[class$='thuiButton--medium']");
}
