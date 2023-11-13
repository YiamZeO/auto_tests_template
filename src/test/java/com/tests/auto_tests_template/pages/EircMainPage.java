package com.tests.auto_tests_template.pages;

import com.codeborne.selenide.SelenideElement;
import com.tests.auto_tests_template.utils.annotations.Element;
import com.tests.auto_tests_template.utils.annotations.Page;

import static com.codeborne.selenide.Selenide.$;

@Page("Главная страница")
public class EircMainPage {
    @Element("'В работе' для первого процесса")
    public SelenideElement firstProcessWorksInTable = $("html > body > div > div:nth-of-type(1) > " +
            "div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) " +
            "> td:nth-of-type(5)");

    @Element("Кнопка 'запустить' для первого процесса")
    public SelenideElement firstProcessStartButtonInTable = $("html > body > div > div:nth-of-type(1) > " +
            "div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > " +
            "td:nth-of-type(6) > button");

    @Element("'startScanFrom' для процесса")
    public SelenideElement inputStartScanFrom = $("input[id='startScanFrom']");

    @Element("'endScanTo' для процесса")
    public SelenideElement inputEndScan = $("input[id='endScanTo']");

    @Element("Кнопка 'запустить' для процесса")
    public SelenideElement startProcessButton = $("button[class$='buttons']");

    @Element("Кнопка 'ОК' для успешного запуска процесса")
    public SelenideElement startProcessOkButton = $("button[class$='thuiButton--medium']");

    @Element("Дата изменения с")
    public SelenideElement inputFilterLastModifiedAfter = $("input[id='filterLastModifiedTsAfter']");
    
    @Element("Дата изменения по")
    public SelenideElement inputFilterLastModifiedBefore = $("input[id='filterLastModifiedTsBefore']");
    
    @Element("Кнопка 'Поиск'")
    public SelenideElement buttonFilter = $("button[class*='search']");
    
    @Element("Первый найденный процесс")
    public SelenideElement firstProcess = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) > " +
            "div > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1)");

    @Element("Журнал процессов")
    public SelenideElement spanJournal = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) " +
            "> div > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > " +
            "span:nth-of-type(2) > span");

    @Element("Ид.ОЖП первого процесса")
    public SelenideElement linkThui = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(2) > div " +
            "> div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(1) > a");

    @Element("Кнопка выгрузки процессов")
    public SelenideElement buttonPrimary =
            $("button[class='thuiButton thuiButton--primary thuiButton--medium']");

    @Element("Кнопка выхода")
    public SelenideElement buttonSmall = $("html > body > div > div:nth-of-type(1) > div:nth-of-type(1) > " +
            "div > div:nth-of-type(2) > button:nth-of-type(2)");
    
}
