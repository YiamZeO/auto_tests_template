package com.tests.auto_tests_template.pages;

import com.codeborne.selenide.SelenideElement;
import com.tests.auto_tests_template.utils.annotations.Element;
import com.tests.auto_tests_template.utils.annotations.Page;

import static com.codeborne.selenide.Selenide.$;

@Page("Страница процесса")
public class EircProcessPage {
    @Element("Сводка процесса")
    public SelenideElement spanCompactNormal = $("html > body > div > div:nth-of-type(1) > " +
            "div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1) > " +
            "span:nth-of-type(2) > span");

    @Element("Кнопка 'Запустить' для операции процесса")
    public SelenideElement buttonOutline = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) " +
            "> div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(6) > button");

    @Element("'startScanFrom' для операции процесса")
    public SelenideElement inputStartScanFrom = $("input[id='startScanFrom']");

    @Element("'endScanTo' для операции процесса")
    public SelenideElement inputEndScan = $("input[id='endScanTo']");

    @Element("Кнопка подтверждения запуска для операции процесса")
    public SelenideElement buttonButtons = $("button[class$='buttons']");

    @Element("Кнопка 'OK' для успешно запущенной операции процесса")
    public SelenideElement buttonPrimary = $("button[class$='thuiButton--medium']");

    @Element("Статус операции процесса")
    public SelenideElement tdDataTable = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) > " +
            "div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(5)");

    @Element("Ид.ОЖП первой операции")
    public SelenideElement linkThui = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) > div " +
            "> div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > a");

    @Element("Кнопка выгрузки операций")
    public SelenideElement buttonPrimary2 =
            $("button[class='thuiButton thuiButton--primary thuiButton--medium']");

    
}
